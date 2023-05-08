import matplotlib.pyplot as plt
import numpy as np


def calculateAvg(depth, array, what):
    counter = 0
    sum = 0
    for items in array:
        if items[1] == depth:
            counter += 1
            sum += items[what]
    return round((sum / counter), 3)


def calculateAvgDFS(depth, array, what):
    counter = 0
    sum = 0
    for items in array:
        if items[2] == -1:
            continue
        if items[1] == depth:
            counter += 1
            sum += items[what]
    return round((sum / counter), 3)


def astarPlot(ytitle, hamming, manhattan):
    y_pos = np.arange(len(hamming))
    fig, axs = plt.subplots(figsize=(10, 7))
    plt.bar(y_pos - 0.15, hamming, width=0.3, color="#1F77B4", label="Hamming")
    plt.bar(y_pos + 0.15, manhattan, width=0.3, color="orange", label="Manhattan")
    plt.legend()
    plt.title("A*", fontsize=25)
    plt.ylabel(ytitle, fontsize=20)
    plt.xlabel("Głębokość", fontsize=20)
    plt.yticks(fontsize=20)
    plt.xticks(fontsize=20)
    plt.xticks(y_pos, range(1, 8, 1))
    plt.show()
    fig.savefig(ytitle + "_ASTAR.png")


def orderPlot(title, ytitle, RDUL, RDLU, DRUL, DRLU, LUDR, LURD, ULDR, ULRD, log,yaxis):
    y_pos = np.arange(len(RDUL))
    fig, ax = plt.subplots(figsize=(10, 7))
    plt.bar(y_pos - 0.4, RDUL, width=0.1, color="#1F77B4", label="RDUL")
    plt.bar(y_pos - 0.3, RDLU, width=0.1, color="orange", label="RDLU")
    plt.bar(y_pos - 0.2, DRUL, width=0.1, color="green", label="DRUL")
    plt.bar(y_pos - 0.1, DRLU, width=0.1, color="red", label="DRLU")
    plt.bar(y_pos, LUDR, width=0.1, color="purple", label="LURD")
    plt.bar(y_pos + 0.1, LURD, width=0.1, color="brown", label="LURD")
    plt.bar(y_pos + 0.2, ULDR, width=0.1, color="pink", label="ULDR")
    plt.bar(y_pos + 0.3, ULRD, width=0.1, color="grey", label="ULRD")
    plt.legend()
    plt.title(title, fontsize=25)
    plt.ylabel(ytitle, fontsize=20)
    plt.xlabel("Głębokość", fontsize=20)
    plt.yticks(fontsize=20)
    plt.xticks(fontsize=20)
    plt.xticks(y_pos, range(1, 8, 1))
    if len(yaxis) != 0:
        plt.yticks(yaxis)
    if log:
        plt.yscale("log")
    plt.show()
    fig.savefig(title + "_" + ytitle + "_ORDER.png")


def plotGeneral(ytitle, bfs, dfs, astar, log, yaxis):
    y_pos = np.arange(len(bfs))
    fig, ax = plt.subplots(figsize=(10, 7))
    plt.bar(y_pos - 0.2, bfs, width=0.2, color="#1F77B4", label="BFS")
    plt.bar(y_pos, dfs, width=0.2, color="orange", label="DFS")
    plt.bar(y_pos + 0.2, astar, width=0.2, color="green", label="A*")
    plt.legend()
    plt.title("Ogółem", fontsize=25)
    plt.ylabel(ytitle, fontsize=20)
    plt.xlabel("Głębokość", fontsize=20)
    plt.yticks(fontsize=20)
    plt.xticks(fontsize=20)
    plt.xticks(y_pos, range(1, 8, 1))
    if len(yaxis) != 0:
        plt.yticks(yaxis)
    if log:
        plt.yscale("log")

    plt.show()
    fig.savefig(ytitle + "_GENERAL.png")


def main():
    bfs = []
    dfs = []
    astar = []
    with open("wyniki.txt", 'r') as file:
        for line in file:
            container = line.split(' ')
            depth = int(container[0])
            name = container[2]
            or_he = container[3]
            solLen = int(container[4])
            visited = int(container[5])
            proceeded = int(container[6])
            maxDepth = int(container[7])
            time = float(container[8].strip('\n'))
            if name == "bfs":
                bfs.append((or_he, depth, solLen, visited, proceeded, maxDepth, time))
            elif name == "dfs":
                dfs.append((or_he, depth, solLen, visited, proceeded, maxDepth, time))
            elif name == "astr":
                astar.append((or_he, depth, solLen, visited, proceeded, maxDepth, time))

    plotBFS = []
    plotDFS = []
    plotASTAR = []

    plotHamming = []
    plotManhattan = []

    BFS_RDUL = []
    BFS_RDLU = []
    BFS_DRUL = []
    BFS_DRLU = []
    BFS_ULDR = []
    BFS_LURD = []
    BFS_LUDR = []
    BFS_ULRD = []

    DFS_RDUL = []
    DFS_RDLU = []
    DFS_DRUL = []
    DFS_DRLU = []
    DFS_ULDR = []
    DFS_LURD = []
    DFS_LUDR = []
    DFS_ULRD = []

    for i in range(1, 8):
        plotBFS.append((
            calculateAvg(i, bfs, 2),
            calculateAvg(i, bfs, 3),
            calculateAvg(i, bfs, 4),
            calculateAvg(i, bfs, 5),
            calculateAvg(i, bfs, 6)
        ))
        plotDFS.append((
            calculateAvg(i, dfs, 2),
            calculateAvg(i, dfs, 3),
            calculateAvg(i, dfs, 4),
            calculateAvg(i, dfs, 5),
            calculateAvg(i, dfs, 6)
        ))
        plotASTAR.append((
            calculateAvg(i, astar, 2),
            calculateAvg(i, astar, 3),
            calculateAvg(i, astar, 4),
            calculateAvg(i, astar, 5),
            calculateAvg(i, astar, 6)
        ))
        plotHamming.append((
            calculateAvg(i, [items for items in astar if items[0] == "hamm"], 2),
            calculateAvg(i, [items for items in astar if items[0] == "hamm"], 3),
            calculateAvg(i, [items for items in astar if items[0] == "hamm"], 4),
            calculateAvg(i, [items for items in astar if items[0] == "hamm"], 5),
            calculateAvg(i, [items for items in astar if items[0] == "hamm"], 6)
        ))
        plotManhattan.append((
            calculateAvg(i, [items for items in astar if items[0] == "manh"], 2),
            calculateAvg(i, [items for items in astar if items[0] == "manh"], 3),
            calculateAvg(i, [items for items in astar if items[0] == "manh"], 4),
            calculateAvg(i, [items for items in astar if items[0] == "manh"], 5),
            calculateAvg(i, [items for items in astar if items[0] == "manh"], 6)
        ))
        BFS_RDUL.append((
            calculateAvg(i, [items for items in bfs if items[0] == "rdul"], 2),
            calculateAvg(i, [items for items in bfs if items[0] == "rdul"], 3),
            calculateAvg(i, [items for items in bfs if items[0] == "rdul"], 4),
            calculateAvg(i, [items for items in bfs if items[0] == "rdul"], 5),
            calculateAvg(i, [items for items in bfs if items[0] == "rdul"], 6)
        ))
        BFS_RDLU.append((
            calculateAvg(i, [items for items in bfs if items[0] == "rdlu"], 2),
            calculateAvg(i, [items for items in bfs if items[0] == "rdlu"], 3),
            calculateAvg(i, [items for items in bfs if items[0] == "rdlu"], 4),
            calculateAvg(i, [items for items in bfs if items[0] == "rdlu"], 5),
            calculateAvg(i, [items for items in bfs if items[0] == "rdlu"], 6)
        ))
        BFS_DRUL.append((
            calculateAvg(i, [items for items in bfs if items[0] == "drul"], 2),
            calculateAvg(i, [items for items in bfs if items[0] == "drul"], 3),
            calculateAvg(i, [items for items in bfs if items[0] == "drul"], 4),
            calculateAvg(i, [items for items in bfs if items[0] == "drul"], 5),
            calculateAvg(i, [items for items in bfs if items[0] == "drul"], 6)
        ))
        BFS_DRLU.append((
            calculateAvg(i, [items for items in bfs if items[0] == "drlu"], 2),
            calculateAvg(i, [items for items in bfs if items[0] == "drlu"], 3),
            calculateAvg(i, [items for items in bfs if items[0] == "drlu"], 4),
            calculateAvg(i, [items for items in bfs if items[0] == "drlu"], 5),
            calculateAvg(i, [items for items in bfs if items[0] == "drlu"], 6)
        ))
        BFS_LUDR.append((
            calculateAvg(i, [items for items in bfs if items[0] == "ludr"], 2),
            calculateAvg(i, [items for items in bfs if items[0] == "ludr"], 3),
            calculateAvg(i, [items for items in bfs if items[0] == "ludr"], 4),
            calculateAvg(i, [items for items in bfs if items[0] == "ludr"], 5),
            calculateAvg(i, [items for items in bfs if items[0] == "ludr"], 6)
        ))
        BFS_LURD.append((
            calculateAvg(i, [items for items in bfs if items[0] == "lurd"], 2),
            calculateAvg(i, [items for items in bfs if items[0] == "lurd"], 3),
            calculateAvg(i, [items for items in bfs if items[0] == "lurd"], 4),
            calculateAvg(i, [items for items in bfs if items[0] == "lurd"], 5),
            calculateAvg(i, [items for items in bfs if items[0] == "lurd"], 6)
        ))
        BFS_ULDR.append((
            calculateAvg(i, [items for items in bfs if items[0] == "uldr"], 2),
            calculateAvg(i, [items for items in bfs if items[0] == "uldr"], 3),
            calculateAvg(i, [items for items in bfs if items[0] == "uldr"], 4),
            calculateAvg(i, [items for items in bfs if items[0] == "uldr"], 5),
            calculateAvg(i, [items for items in bfs if items[0] == "uldr"], 6)
        ))
        BFS_ULRD.append((
            calculateAvg(i, [items for items in bfs if items[0] == "ulrd"], 2),
            calculateAvg(i, [items for items in bfs if items[0] == "ulrd"], 3),
            calculateAvg(i, [items for items in bfs if items[0] == "ulrd"], 4),
            calculateAvg(i, [items for items in bfs if items[0] == "ulrd"], 5),
            calculateAvg(i, [items for items in bfs if items[0] == "ulrd"], 6)
        ))
        DFS_RDUL.append((
            calculateAvgDFS(i, [items for items in dfs if items[0] == "rdul"], 2),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "rdul"], 3),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "rdul"], 4),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "rdul"], 5),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "rdul"], 6)
        ))
        DFS_RDLU.append((
            calculateAvgDFS(i, [items for items in dfs if items[0] == "rdlu"], 2),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "rdlu"], 3),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "rdlu"], 4),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "rdlu"], 5),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "rdlu"], 6)
        ))
        DFS_DRUL.append((
            calculateAvgDFS(i, [items for items in dfs if items[0] == "drul"], 2),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "drul"], 3),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "drul"], 4),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "drul"], 5),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "drul"], 6)
        ))
        DFS_DRLU.append((
            calculateAvgDFS(i, [items for items in dfs if items[0] == "drlu"], 2),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "drlu"], 3),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "drlu"], 4),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "drlu"], 5),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "drlu"], 6)
        ))
        DFS_LUDR.append((
            calculateAvgDFS(i, [items for items in dfs if items[0] == "ludr"], 2),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "ludr"], 3),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "ludr"], 4),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "ludr"], 5),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "ludr"], 6)
        ))
        DFS_LURD.append((
            calculateAvgDFS(i, [items for items in dfs if items[0] == "lurd"], 2),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "lurd"], 3),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "lurd"], 4),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "lurd"], 5),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "lurd"], 6)
        ))
        DFS_ULDR.append((
            calculateAvgDFS(i, [items for items in dfs if items[0] == "uldr"], 2),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "uldr"], 3),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "uldr"], 4),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "uldr"], 5),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "uldr"], 6)
        ))
        DFS_ULRD.append((
            calculateAvgDFS(i, [items for items in dfs if items[0] == "ulrd"], 2),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "ulrd"], 3),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "ulrd"], 4),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "ulrd"], 5),
            calculateAvgDFS(i, [items for items in dfs if items[0] == "ulrd"], 6)
        ))

    plotGeneral("Długość rozwiązania", [x[0] for x in plotBFS], [x[0] for x in plotDFS], [x[0] for x in plotASTAR],
                False, [])
    plotGeneral("Liczba stanów odwiedzonych", [x[1] for x in plotBFS], [x[1] for x in plotDFS],
                [x[1] for x in plotASTAR], True, [])
    plotGeneral("Liczba stanów przetworzonych", [x[2] for x in plotBFS], [x[2] for x in plotDFS],
                [x[2] for x in plotASTAR], True, [])
    plotGeneral("Maksymalna głębokość", [x[3] for x in plotBFS], [x[3] for x in plotDFS], [x[3] for x in plotASTAR],
                False, range(0, 21, 2))
    plotGeneral("Czas trwania obliczen", [x[4] for x in plotBFS], [x[4] for x in plotDFS], [x[4] for x in plotASTAR],
                True, [])

    astarPlot("Długość rozwiązania", [x[0] for x in plotHamming], [x[0] for x in plotManhattan])
    astarPlot("Liczba stanów odwiedzonych", [x[1] for x in plotHamming], [x[1] for x in plotManhattan])
    astarPlot("Liczba stanów przetworzonych", [x[2] for x in plotHamming], [x[2] for x in plotManhattan])
    astarPlot("Maksymalna głębokość", [x[3] for x in plotHamming], [x[3] for x in plotManhattan])
    astarPlot("Czas trwania obliczeń", [x[4] for x in plotHamming], [x[4] for x in plotManhattan])

    orderPlot("BFS", "Długość rozwiązania",
              [x[0] for x in BFS_RDUL],
              [x[0] for x in BFS_RDLU],
              [x[0] for x in BFS_DRUL],
              [x[0] for x in BFS_DRLU],
              [x[0] for x in BFS_LUDR],
              [x[0] for x in BFS_LURD],
              [x[0] for x in BFS_ULDR],
              [x[0] for x in BFS_ULRD],
              False,[])

    orderPlot("BFS", "Liczba stanów odwiedzonych",
              [x[1] for x in BFS_RDUL],
              [x[1] for x in BFS_RDLU],
              [x[1] for x in BFS_DRUL],
              [x[1] for x in BFS_DRLU],
              [x[1] for x in BFS_LUDR],
              [x[1] for x in BFS_LURD],
              [x[1] for x in BFS_ULDR],
              [x[1] for x in BFS_ULRD],
              True,[])

    orderPlot("BFS", "Liczba stanów przetworzonych",
              [x[2] for x in BFS_RDUL],
              [x[2] for x in BFS_RDLU],
              [x[2] for x in BFS_DRUL],
              [x[2] for x in BFS_DRLU],
              [x[2] for x in BFS_LUDR],
              [x[2] for x in BFS_LURD],
              [x[2] for x in BFS_ULDR],
              [x[2] for x in BFS_ULRD],
              True,[])

    orderPlot("BFS", "Maksymlana głębokość",
              [x[3] for x in BFS_RDUL],
              [x[3] for x in BFS_RDLU],
              [x[3] for x in BFS_DRUL],
              [x[3] for x in BFS_DRLU],
              [x[3] for x in BFS_LUDR],
              [x[3] for x in BFS_LURD],
              [x[3] for x in BFS_ULDR],
              [x[3] for x in BFS_ULRD],
              False,[])

    orderPlot("BFS", "Czas trwania obliczeń",
              [x[4] for x in BFS_RDUL],
              [x[4] for x in BFS_RDLU],
              [x[4] for x in BFS_DRUL],
              [x[4] for x in BFS_DRLU],
              [x[4] for x in BFS_LUDR],
              [x[4] for x in BFS_LURD],
              [x[4] for x in BFS_ULDR],
              [x[4] for x in BFS_ULRD],
              False,[])

    orderPlot("DFS", "Długość rozwiązania",
              [x[0] for x in DFS_RDUL],
              [x[0] for x in DFS_RDLU],
              [x[0] for x in DFS_DRUL],
              [x[0] for x in DFS_DRLU],
              [x[0] for x in DFS_LUDR],
              [x[0] for x in DFS_LURD],
              [x[0] for x in DFS_ULDR],
              [x[0] for x in DFS_ULRD],
              False,range(0,19,2))

    orderPlot("DFS", "Liczba stanów odwiedzonych",
              [x[1] for x in DFS_RDUL],
              [x[1] for x in DFS_RDLU],
              [x[1] for x in DFS_DRUL],
              [x[1] for x in DFS_DRLU],
              [x[1] for x in DFS_LUDR],
              [x[1] for x in DFS_LURD],
              [x[1] for x in DFS_ULDR],
              [x[1] for x in DFS_ULRD],
              True,[])

    orderPlot("DFS", "Liczba stanów przetworzonych",
              [x[2] for x in DFS_RDUL],
              [x[2] for x in DFS_RDLU],
              [x[2] for x in DFS_DRUL],
              [x[2] for x in DFS_DRLU],
              [x[2] for x in DFS_LUDR],
              [x[2] for x in DFS_LURD],
              [x[2] for x in DFS_ULDR],
              [x[2] for x in DFS_ULRD],
              True,[])

    orderPlot("DFS", "Maksymlana głębokość",
              [x[3] for x in DFS_RDUL],
              [x[3] for x in DFS_RDLU],
              [x[3] for x in DFS_DRUL],
              [x[3] for x in DFS_DRLU],
              [x[3] for x in DFS_LUDR],
              [x[3] for x in DFS_LURD],
              [x[3] for x in DFS_ULDR],
              [x[3] for x in DFS_ULRD],
              False,range(0,21,2))

    orderPlot("DFS", "Czas trwania obliczeń",
              [x[4] for x in DFS_RDUL],
              [x[4] for x in DFS_RDLU],
              [x[4] for x in DFS_DRUL],
              [x[4] for x in DFS_DRLU],
              [x[4] for x in DFS_LUDR],
              [x[4] for x in DFS_LURD],
              [x[4] for x in DFS_ULDR],
              [x[4] for x in DFS_ULRD],
              True,[])


if '__main__':
    main()
