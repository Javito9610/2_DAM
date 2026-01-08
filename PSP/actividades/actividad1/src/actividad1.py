import subprocess

proceso1 = subprocess.Popen(["notepad.exe"]);
proceso2 = subprocess.Popen([r"C:\Program Files (x86)\Google\Chrome\Application\chrome.exe"]);
proceso3 = subprocess.Popen([r"C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe"]);

print("Procesos lanzados:")

print("PID 1:", proceso1.pid);
print("PID 2:", proceso2.pid);
print("PID 3:", proceso3.pid);

proceso1.wait();
proceso2.wait();
proceso3.wait();
print("Los 3 procesos han finalizado");