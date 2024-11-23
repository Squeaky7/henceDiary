import datetime
import os
import json
import file_id_genr as fileid

date = datetime.datetime.now()

current_datetime = datetime.datetime.now().strftime('%Y-%m-%d_%H%M%S')

file_path = os.path.join("tests", "ThoughBuckets", f"{current_datetime}.txt")



# print(os.getcwd())

tagArray = []



with open(file_path, 'w') as file:
    
    file.seek(0)

    print(date)

    title = input("What are you thinking about?\n[Title]:")

    user_input = input("Enter text: ")

    tagTF = input("Do you want tag?[y/N]: ")

    if tagTF == "y":
        tagEnter = True
        while tagEnter:
            tags = input("Enter tag (Enter \"q\" to finish): ")
            
            if tags == "q":
                break
            
            tagArray.append(tags)
    
    tag_save = ""
    for i in range(len(tagArray)):
        tag_save += f"#{tagArray[i]} "
    print(f"Formatted tags for saving: {tag_save}")

    file_id = fileid.fileIdGenerator(16)

    file.write(f"Datetime: {current_datetime}\nFile ID: {file_id}\nTag: {tag_save}\nTitle: {title}\n{user_input}")




