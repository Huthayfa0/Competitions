from random import random
from random import randint
from os import listdir
import numpy as np
import pygad

dictionary = dict()
people = []


class Person:
    def __init__(self):
        self.loves = []
        self.hates = []

    def love(self, string):
        arr = string.split(' ')
        arr.pop(0)
        self.loves = arr

    def hate(self, string):
        arr = string.split(' ')
        arr.pop(0)
        self.hates = arr


def output(ans, file_name):
    f = open('output_data/' + file_name, 'w')
    string = str(len(ans)) + ' '
    string += ' '.join(ans)
    f.write(string)
    f.close()


def fitness_func(solution, solution_idx):
    fitness = 0
    for p in people:
        b = True
        for l in p.loves:
            if solution[dictionary[l]] == 0:
                b = False
        for h in p.hates:
            if solution[dictionary[h]] == 1:
                b = False
        if b:
            fitness += 1
    return fitness


def solve(file_name):
    data = open('input_data/' + file_name, 'r')
    n = int(data.readline())
    global people
    people = []
    for i in range(n):
        p = Person()
        p.love(data.readline().replace('\n', ''))
        p.hate(data.readline().replace('\n', ''))
        people.append(p)
    ans = set()
    for p in people:
        for love in p.loves:
            ans.add(love)
    n = len(ans)
    count = np.zeros(n)
    for p in people:
        new_hates = []
        for hate in p.hates:
            if hate in ans:
                new_hates.append(hate)
        p.hates = new_hates
    ans = list(ans)
    global dictionary
    dictionary = dict()
    for i in range(n):
        dictionary[ans[i]] = i
    for p in people:
        for h in p.hates:
            count[dictionary[h]] += 1
        for l in p.loves:
            count[dictionary[l]] -= 1
    x = min(count)
    for i in range(n):
        count[i] -= x - 1
    sm = sum(count)
    pop = [np.ones(n)]
    for i in range(1, 10):
        cur = np.ones(n)
        for j in range(randint(0, n)):
            x = random() * sm
            for k in range(n):
                if x <= count[k]:
                    cur[k] = 1 - cur[k]
                    break
                x -= count[k]
        pop.append(cur)

    ga = pygad.GA(fitness_func=fitness_func, gene_space=[0, 1], num_generations=10,
                  num_parents_mating=5, initial_population=pop, mutation_probability=0.1
                  , crossover_type='uniform')
    ga.run()
    ga.plot_fitness(title=file_name)
    lst = ga.best_solution()[0]
    new_ans = []
    for i in range(n):
        if lst[i] == 1:
            new_ans.append(ans[i])
    ans = new_ans
    output(ans, file_name)
    print('{} file is done.'.format(file_name))


for file in listdir('input_data'):
    solve(file)
