from multiprocessing import Process
import os

def foo():
    with open('step3_test.txt', 'a') as f:
        f.write('나는 1번 자식 프로세스입니다.\n')

def bar():
    with open('step3_test.txt', 'a') as f:
        f.write('나는 2번 자식 프로세스입니다.\n')

def baz():
    with open('step3_test.txt', 'r') as f:
        for line in f:
            print(line.strip())


if __name__ == '__main__':
    with open('step3_test.txt', 'w') as f:
        pass

    child1 = Process(target=foo)
    child2 = Process(target=bar)
    child3 = Process(target=baz)
    child1.start()
    child2.start()
    child3.start()
    child1.join()
    child2.join()
    child3.join()
