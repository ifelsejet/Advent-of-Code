my_file = open("C:\\Users\\ifels\\Documents\\GitHub\\Advent-of-Code\\2021\\Day_03\\test.txt", "r")
content_list = my_file.readlines()
print(content_list)
i = 0
nums0= 0
nums1=0
convList = []
leng = len(content_list)
print("Length of list: ", leng)
count = 0
for i in content_list:
    count += 1
    print("Ayo i is {}".format(count))
    if(i[0] == '0'):
        nums0 += 1
    elif(i[0] == '1'):
        nums1+= 1
    if(int(count) == 12):
        print("index i at: {}".format(i))
        count = 0
        print("Nums 0 & Nums 1: {}, {}".format(nums0,nums1))
        if(nums0 > nums1):
            convList.append('0')
        else:
            convList.append('1')
        nums0 = 0
        nums1 = 0

print(nums0)
print(nums1)
print(convList)

    
