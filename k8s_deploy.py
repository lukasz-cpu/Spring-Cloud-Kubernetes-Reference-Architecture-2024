import subprocess
import os

def build_docker_image(project_dir):
    if not os.path.isdir(project_dir):
        print(f"Folder {project_dir} does not exist.")
        return

    os.chdir(project_dir)
    print(f"Going to the folder: {project_dir}")

    try:
        print("Starting Docker build.....")
        process = subprocess.Popen(
            ["docker", "build", "-t", "emergency-room-service:latest", "."],
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
            print("Docker build done.")
        else:
            print("Error occurred during Docker build!")

    except subprocess.CalledProcessError as e:
        print("Error occurred during Docker build!")
        print(e.stderr)


if __name__ == "__main__":
    project_path = "./emergency-room-service/"

    build_docker_image(project_path)
