import datetime
import os
import json


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
            tagArray.append(tags)
            if tags == "q":
                break

    file.write(f"Datetime: {datetime.datetime.now()}\n\nTag: \nTitle: {title}\n{user_input}")




