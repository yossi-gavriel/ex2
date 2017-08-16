from jsonFileToTextFile import main
import time
import matplotlib.pyplot as graph


pythonTimes = [] # get the times array of python by running the main program 100 times
for i in range(100):
    start = time.time()
    main()
    end = time.time()
    pythonTimes.append(float(end - start))

print(pythonTimes)

with open('JavaTimes.txt') as run_file: # get the times array of java from text file that i made by java
    arr = run_file.read()
    arr = arr[1:-1].split(', ')
    javaTimes = []
    for i in arr :
        javaTimes.append(float(i))

bins = [0.01 , 0.02 , 0.03 , 0.04 , 0.05 ] # for the graph

table , (pythonGrafh , javaGrafh) = graph.subplots(ncols = 2, figsize=(12, 7)) # create a table from the 2 graphs

pythonGrafh.hist(pythonTimes, bins, color='g')
pythonGrafh.set_title('python ')
javaGrafh.hist(javaTimes, bins, color='r')
javaGrafh.set_title('java ')
graph.show()
print()