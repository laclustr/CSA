import os

base_dir = "."
file_extension = ".java"
prefix = "Class"

def get_next_numbered_name(existing_dirs):
    max_number = max(int(name) for name in existing_dirs if name.isdigit()) if existing_dirs else 0
    return f"{prefix}{max_number + 1:04d}"

existing_dirs = [
    name.replace(prefix, "") 
    for name in os.listdir(base_dir)
    if os.path.isdir(name) and name.startswith(prefix) and name.replace(prefix, "").isdigit()]
next_dir_name = get_next_numbered_name(existing_dirs)

while True:
    if next_dir_name in existing_dirs:
        existing_dirs.remove(next_dir_name)
        next_dir_name = get_next_numbered_name(existing_dirs)
    else:
        os.mkdir(next_dir_name)
        with open(os.path.join(next_dir_name, f"{next_dir_name}{file_extension}"), "w") as file:
            file.write(f"public class {next_dir_name} {{\n\tpublic static void main(String[] args) {{\n\t\t\n\t}}\n}}")

        break
