numsToCheck = []

with open("C:\\Users\\ifels\\Documents\\GitHub\\Advent-of-Code\\2021\\Day_04\\input.txt") as f:
    lines = f.read()
    first = lines.split('\n', 1)[0].strip()
    first = first.split()

for word in first:
    numsToCheck.extend(word.split(","))
#numsToCheck = first.copy()
numsToCheck = [int(item) for item in numsToCheck]
print(numsToCheck)


lines = []
lineNum = 0
with open("C:\\Users\\ifels\\Documents\\GitHub\\Advent-of-Code\\2021\\Day_04\\input.txt") as textFile:
    for line in textFile:
        if(lineNum == 0 or lineNum == 1 or lineNum == 2 or line == " "):
            print("SKIP FIRST LINE AND SECOND LINE")
            lineNum += 1

        else:
            lines.append(list(map(int, line.split())))

        lineNum += 1
        #print(lineNum, (line))
        if(line == ""):
            print("RAN THE THING ")
        #print(line)
        
    #lines = [line.split() for line in textFile]
bingoBoard = [ele for ele in lines if ele != []]
boards = []
i = 0

# 100 boards

for i in range(len(bingoBoard)):
    start = i * 5
    end = start + 5
    board = bingoBoard[start:end]
    boards.append(board)
    board = []


boardsNew = [ele for ele in boards if ele != []]


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


print("BROOOOOOOOOOOOOOOOOOO PLEASEEEEEEEEEEE")
print(bingoBoard)

bingo =['X','X','X','X','X']
winningBoard = []

def check4Num(board, num):
        for r in range(5):
            for c in range(5):
                if board[r][c] == num:
                    board[r][c] = 'X'
                    return r, c
        return None, None

def check4Win(board, index, r, c):
        # check valid
        if r == None or c == None:
            return None

        # check row
        row = board[r]
        if row == bingo:
            return boards[index][r]
        
        # check col
        col = [board[i][c] for i in range(5)]
        if col == bingo:
            return [boards[index][i][c] for i in range(5)]
        
        # if both row and col are won
        return None
mult = []
for num in numsToCheck:
    for index, board in enumerate(boardsNew):
        r, c = check4Num(board,num)
        winningBoard = check4Win(board, index, r, c)
        if winningBoard != None:
                    marked = 0
                    for i in range(5):
                        for j in range(5):
                            marked += (boards[index][i][j] if board[i][j] != 'X' else 0)
                    mult.append(marked * num)
                    print(marked * num)

print("Solution 1 is: ", mult[0]) #5008
print("Solution 2 is: ", mult[-1]) #5008

"""
for num in numsToCheck:
    for index, board in enumerate(boardsNew):
        for r in range(5):
            for c in range(5):
                if board[r][c] == num:
                    board[r][c] = 'X'
                    print(r,c)
    if r != None or c != None:
        row = board[r]
        if row == bingo:
            print(boards[index][r])
            winningBoard = boards[index][r]
            
        col = [board[i][c] for i in range(5)]
        if col == bingo:
            print([boards[index][i][c] for i in range(5)])
            winningBoard = [boards[index][i][c] for i in range(5)]

    if winningBoard != None:
        unmarked = 0
        for i in range(5):
            for j in range(5):
                unmarked += (boards[index][i][j] if board[i][j] != 'X' else 0)
                print("Solution is: ", unmarked * num)

"""
