from multiprocessing import Process
import os

def foo():
    print('child process ', os.getpid())
    print('my parent is ', os.getppid())

if __name__ == '__main__':
    print('parent process ', os.getpid())
    child = Process(target=foo)
    child.start()
    child.join()
