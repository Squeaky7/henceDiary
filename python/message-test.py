import tkinter

root = tkinter.Tk()
root.geometry("600x400")
root.title("Message App")

font_style = ("Helvetica", 14)
entry_bg_color = "white"
button_bg_color = "lightblue"



# Input Action
def submit_action ():
    input_text = entry.get()
    if input_text:
        print(f"Input: {input_text}")
        entry.delete(0, tkinter.END)
    else:
        print("No Input Provided!")

# Canvas
canvas = tkinter.Canvas(
    root,
    width= 600,
    height= 400
)
canvas.pack(side= tkinter.TOP)

canvas.create_line(0, 100, 600, 100, width= 2, fill= "black")

# Input Field
entry = tkinter.Entry(
    root,
    bg= entry_bg_color,
    fg= "black",
    width= 45,
    font= font_style,
)
entry.place(x= 130, y= 20)

# Button
submit_button = tkinter.Button(
    root,
    text= "Submit",
    bg= button_bg_color,
    fg= "black",
    activebackground= "blue",
    width= 5,
    height= 1,
    font= font_style,
    command= submit_action
)
submit_button.place(x= 200, y= 200)

# Enter Diary
text_display = tkinter.Text(
    root,
    font= font_style,
    width= 60,
    height= 10,
    bg= entry_bg_color
)

# Label
label = tkinter.Label(
    root,
    font= font_style,
    text= "Title (Optional): "
)
label.place(x= 20, y= 20)



root.mainloop()