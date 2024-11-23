import datetime
import os
import json
import file_id_genr as fileid

current_datetime = datetime.datetime.now().strftime('%Y-%m-%d_%H%M%S')
print(f"Saved time on file is {current_datetime}(The file name is {current_datetime}.txt)")

folder_path = os.path.join("tests", "ThoughBuckets")

os.makedirs(folder_path, exist_ok= True)

file_path = os.path.join(folder_path, f"{current_datetime}.txt")
print(f"The file path is {file_path}")

json_path = os.path.join(folder_path, "file_link.json")
print(f"The JSON file name is {json_path}")

# print(os.getcwd())

tagArray = []



with open(file_path, 'w') as file:

    print(f"Date is {current_datetime}")

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

    print(f"File ID: {file_id}\nTitle: {title}\nTag(s): {tag_save}")

    file.write(f"Datetime: {current_datetime}\nFile ID: {file_id}\nTag: {tag_save}\nTitle: {title}\n{user_input}")

new_entry = {
    "file_id": file_id,
    "file_name": f"{current_datetime}.txt",
    "tag(s)": tagArray,
    "input_date": current_datetime,
    "title": title
}

if os.path.exists(json_path):
    with open(json_path, 'r') as json_file:
        try:
            data = json.load(json_file)
            if not isinstance(data,list):
                data = [data]

        except json.JSONDecodeError:
            data = []
else:
    data = []
            
data.append(new_entry)

with open(json_path, 'w', encoding='utf-8') as json_file:
    json.dump(data, json_file, ensure_ascii=False, indent= 4)

