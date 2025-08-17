import threading
import os

def foo():
    print('thread id ', threading.get_ident())
    print('process id ', os.getpid())

if __name__ == '__main__':
    print('process id ', os.getpid())
    thread = threading.Thread(target=foo).start()