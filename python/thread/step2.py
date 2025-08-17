import threading
import os

def foo():
    print('thread id ', threading.get_ident())
    print('process id ', os.getpid())

if __name__ == '__main__':
    print('process id ', os.getpid())
    thread1 = threading.Thread(target=foo).start()
    thread2 = threading.Thread(target=foo).start()
    thread3 = threading.Thread(target=foo).start()