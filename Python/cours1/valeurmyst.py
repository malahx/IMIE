
import random
import pickle
import os.path

MAX_TRY = 7
MIN_VALUE = 0
MAX_VALUE = 100
FILE = "game.save"


class Player:
    def __init__(self, nick, score):
        self.nick = nick
        self.score = score

    def __repr__(self):
        return repr((self.nick, self.score))


class Game:
    def __init__(self):
        nick = input("Enter your nickname\n")
        self.players = Game.load_player()
        self.player = Player(nick, MAX_TRY)
        save_player = Game.find_player(self.players, self.player)
        if save_player is not None:
            save_player.score += MAX_TRY
            self.player = save_player
        else:
            self.players.append(self.player)
        self.max_value = int(MAX_VALUE * self.player.score / MAX_TRY)
        self.value = random.randint(MIN_VALUE, self.max_value)
        self.start()

    @staticmethod
    def load_player():
        if os.path.isfile(FILE):
            save = open(FILE, 'rb')
            players = pickle.load(save)
            save.close()
        else:
            players = list()
        return players

    @staticmethod
    def find_player(players, player):
        for p in players:
            if p.nick == player.nick:
                return p
        return None

    def display_players(self):
        players = sorted(self.players, key=lambda player: player.score, reverse=True)
        for i, player in enumerate(players):
            print(i+1, player)

    def start(self):
        print("You have to enter a number between {0} and {1}".format(MIN_VALUE, self.max_value))
        while True:
            try:
                val = int(input("What is the value, you have {0} try\n".format(self.player.score)))
                self.player.score -= 1
                if val == self.value:
                    self.win()
                    break
                elif self.player.score <= 0:
                    self.lost("You lost")
                    break
                elif val < self.value:
                    print("More")
                elif val > self.value:
                    print("Less")
            except:
                self.lost("You try to cheat")
                break

    def win(self):
        self.result("You win")

    def lost(self, message):
        self.player.score = -1
        self.result("{0}, it was {1}".format(message, self.value))

    def result(self, message):
        print(message)
        save = open(FILE, 'wb')
        pickle.dump(self.players, save)
        save.close()
        self.display_players()


game = Game()
