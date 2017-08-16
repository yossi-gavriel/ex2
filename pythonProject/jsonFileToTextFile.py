import json

class jsonToFile:
    '''
    this class is contain a Array of object with "name" and "password"
    this class have main methods :
    1- read json file and put his information in a json object
    2- put the information from the json object in text file
    which every element in the array write as the form : "name: (hashcode of the password of the user)"
    '''

    def __init__(self):

        '''
        constructor
        '''
        self.outJasonObject = []


    def read(self, inPutFile):
        '''
        this function get a String that represent a jason file and take the array that inside the file
        and put it in array of jasons and put the array in a JSONObject
        :param inPutFile:
        :return:
        '''
        json_data = open(inPutFile).read()
        #json_data = open('C:\TestFile.json').read()

        inputData = json.loads(json_data)
        outJasonArray = []

        for i in range(len(inputData)):
            userToAdd = inputData[i]["username"] + ":" + (str)(hash(inputData[i]["password"]))
            outJasonArray.append(userToAdd)

            self.outJasonObject = {'users': outJasonArray}


    def write(self, outPutFile):
        '''
        this function get the String that represent the name of the output file
        and write the current jason object into the file
        :param outPutFile:
        :return:
        '''
        with open(outPutFile, 'w') as outfile:

            json.dump(self.outJasonObject, outfile)
            outfile.close();

    def toString(self):
        '''
        print the result to the screen
        '''
        print("\nJSON Object: "+ (str)(self.outJasonObject))

#@profile
def main():
    '''
    make the main propose of the ex -> convert a json file to text file with hashing on the passwords
    using the jsonToFile object that i was make and on his function
    '''
    x= jsonToFile() # create a new jsonToFile object

    x.read('TestFile.json') # read the json file

    x.write('outPutFile.txt') # write the json object to the given text file

    x.toString() # print the result to the screen


main()
