#1 for website 2 for competition 3 for file name
[ ! -d 'src/'$1 ] && mkdir 'src/'$1
[ ! -d 'src/'$1'/'$2 ] && mkdir 'src/'$1'/'$2
[ -d 'src/'$1'/'$2'/'$3'.cpp' ] && mv 'src/'$1'/'$2'/'$3'.cpp' 'src/'$1'/'$2'/'$3'pre.cpp'
cp '/home/huthayfa/CLionProjects/UnderHeat/main.cpp' 'src/'$1'/'$2'/'$3'.cpp' 
git add 'src/'$1'/'$2
git commit -m "$2"

