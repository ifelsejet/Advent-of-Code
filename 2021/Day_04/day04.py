numsToCheck = []

with open("C:\\Users\\ifels\\Documents\\GitHub\\Advent-of-Code\\2021\\Day_04\\input.txt") as f:
    lines = f.read()
    first = lines.split('\n', 1)[0].strip()
    first = first.split()

for word in first:
    numsToCheck.extend(word.split(","))
#numsToCheck = first.copy()
print(numsToCheck)
lines = []
lineNum = 0
with open("C:\\Users\\ifels\\Documents\\GitHub\\Advent-of-Code\\2021\\Day_04\\input.txt") as textFile:
    for line in textFile:
        if(lineNum == 0 or lineNum == 1 or lineNum == 2 or line == " "):
            print("SKIP FIRST LINE AND SECOND LINE")
            lineNum += 1

        else:
            lines.append(line.split())


        lineNum += 1
        #print(lineNum, (line))
        if(line == ""):
            print("RAN THE THING ")
        #print(line)
        
    #lines = [line.split() for line in textFile]
bingoBoard = [ele for ele in lines if ele != []]


print(bingoBoard)
cnt = 0 
print("------------------")
for x in range(len(bingoBoard)):
    if(x % 5 == 0):
        print("A NEW BOARD")
        print()
        cnt += 1 
    print(bingoBoard[x])
print("+++++++++++++++")
print(numsToCheck[0])    
print(type(numsToCheck[0]))    

for r in bingoBoard:
   for c in r:
      if c == str(numsToCheck[0]):
          c="*"
      print(c,end = " ")
   print()

print(cnt)
drawn = []