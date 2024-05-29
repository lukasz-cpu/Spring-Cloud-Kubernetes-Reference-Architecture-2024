import subprocess
import os

def run_maven_clean_install(project_dir):
    # Sprawdzenie, czy podany katalog istnieje
    if not os.path.isdir(project_dir):
        print(f"Katalog {project_dir} nie istnieje.")
        return

    # Przejście do katalogu projektu
    os.chdir(project_dir)
    print(f"Przechodzę do katalogu: {project_dir}")

    # Wykonanie komendy maven clean install
    try:
        result = subprocess.run(["mvn", "clean", "install"], check=True, universal_newlines=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        print("Kompilacja zakończona sukcesem.")
        print(result.stdout)
    except subprocess.CalledProcessError as e:
        print("Wystąpił błąd podczas kompilacji.")
        print(e.stderr)

if __name__ == "__main__":
    # Podaj ścieżkę do swojego projektu
    project_path = "./emergency-room-service/"

    run_maven_clean_install(project_path)