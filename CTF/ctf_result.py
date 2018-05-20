import requests
from bs4 import *
import time

team = {}


def calc_score(url):
    while 1:
        response = requests.get(url)
        soup = BeautifulSoup(response.text, "html.parser")
        trs = soup.tbody.find_all('tr')
        print("-------------------------------------------------------")
        for tr in trs:
            if tr.td.a.text not in team.keys():
                team[tr.td.a.text] = []
            team[tr.td.a.text].append(int(tr.find_all('td')[1].text))
            if len(team[tr.td.a.text]) >= 2:
                print("{:s}: {:d} (+{:d})".format(tr.td.a.text, int(tr.find_all('td')[1].text), int(calc(team[tr.td.a.text]))))
                team[tr.td.a.text].pop(0)
            else:
                print("{:s}: {:d}, more data needed: {:d}".format(tr.td.a.text, int(tr.find_all('td')[1].text), len(team[tr.td.a.text])))
        time.sleep(30)


def calc(scores):
    score = scores[1] - scores[0]
    return score


if __name__ == "__main__":
    calc_score('http://192.168.14.64/app.php/team/')