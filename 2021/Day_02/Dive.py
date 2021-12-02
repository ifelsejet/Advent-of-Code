my_file = open("C:\\Users\\ifels\\Documents\\GitHub\\Advent-of-Code\\2021\\Day_02\\input.txt", "r")
content_list = my_file.readlines()
converted_list = []

for element in content_list:
    converted_list.append(element.strip())

hPos = 0
depth = 0
aim = 0

for element in content_list:
    if "down" in element:
        X = [int(i) for i in element.split() if i.isdigit()]
        X = sum(X)
        #depth += X Comment for Sol 1
        aim += X
        print("Depth is {}".format(depth))
        print("Aim increased by {}, aim is {}".format(X, aim))

    elif "forward" in element:
        X = [int(i) for i in element.split() if i.isdigit()]
        X = sum(X)
        hPos += X
        depth = depth + int(aim*X)
        print("Horizontal position is {}".format(hPos))
        print("Depth is {}".format(depth))

    elif "up" in element:
        X = [int(i) for i in element.split() if i.isdigit()]
        X = sum(X)
       # depth = depth - X
        aim = aim - X
        print("Depth is {}".format(depth))
        print("Aim decreased by {}, aim is {}".format(X, aim))

print("Sol 1: ", (hPos*depth)) 
print("Sol 2: ", (hPos*depth)) 