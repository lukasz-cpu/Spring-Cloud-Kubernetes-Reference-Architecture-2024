import subprocess
import os


def run_maven_clean_install(project_dir):
    if not os.path.isdir(project_dir):
        print(f"Folder {project_dir} does not exist.")
        return

    os.chdir(project_dir)
    print(f"Going to the folder: {project_dir}")

    try:
        print("Starting compiling.....")
        process = subprocess.Popen(
            ["mvn", "clean", "install"],
            stdout=subprocess.PIPE,
            stderr=subprocess.STDOUT,
            universal_newlines=True
        )

        while True:
            output = process.stdout.readline()
            if output == '' and process.poll() is not None:
                break
            if output:
                print(output.strip())

        rc = process.poll()
        if rc == 0:
            print("Compilation done.")
        else:
            print("Error occurred during compiling!")

    except subprocess.CalledProcessError as e:
        print("Error occurred during compiling!")
        print(e.stderr)


if __name__ == "__main__":
    project_path = "./emergency-room-service/"

    run_maven_clean_install(project_path)
