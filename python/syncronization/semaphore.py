from threading import Thread, Semaphore

num = 0
sem = Semaphore(1)

def foo(sem):
    global num
    sem.acquire()
    for _ in range(100000):
        num += 1
    sem.release()

if __name__ == '__main__':
    t1 = Thread(target=foo, args=(sem,))
    t2 = Thread(target=foo, args=(sem,))

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    print(num)