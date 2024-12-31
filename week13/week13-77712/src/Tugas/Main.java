package Tugas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Player> arrPlayers = new ArrayList<>();
        bigBoss boss = new bigBoss();
        BattleLog report = new BattleLog() {
            @Override
            public void playerHitBack(Player player, int damageReductionFromBoss) {
                System.out.println("--- Battle Log ---");
                System.out.printf("Player               : %-15s%n", player.getName());
                System.out.printf("Damage Given To Boss : %-10d%n", damageReductionFromBoss);
                System.out.printf("Current Energy       : %-10d%n", player.getEnergy());
                System.out.printf("Current HitPoint     : %-10d%n", player.getHitPoint());
                System.out.printf("Health Boss          : %-10d%n", boss.getHitPoint());
                System.out.println();
            }

            @Override
            public void reportBattle(Player player, int damageGivenToBoss, int hitPointBoss) {
                System.out.println("--- Battle Log ---");
                System.out.printf("Player               : %-15s%n", player.getName());
                System.out.printf("Damage Given To Boss : %-10d%n", damageGivenToBoss);
                System.out.printf("Current Energy       : %-10d%n", player.getEnergy());
                System.out.printf("Current HitPoint     : %-10d%n", player.getHitPoint());
                System.out.printf("Health Boss          : %-10d%n", hitPointBoss);
                System.out.println();
            }
        };

        arrPlayers.add(new Player("Knight", 200, 15, 30));
        arrPlayers.add(new Player("Archer", 50, 18, 40));
        arrPlayers.add(new Player("Barbarians", 300, 23, 50));
        arrPlayers.add(new Player("Ninja", 400, 17, 40));

        System.out.println("Hello Minna San");
        System.out.println("Welcome to RPG Game");

        int choice;
        do {
            System.out.println("1. Add Player");
            System.out.println("2. Hit Boss");
            System.out.println("3. Exit Game");
            System.out.print("Pilihan       : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nama          : ");
                    String name = scanner.nextLine();
                    System.out.print("Hit Point     : ");
                    int hitPoint = scanner.nextInt();
                    System.out.print("Damage        : ");
                    int damage = scanner.nextInt();
                    System.out.print("Energy        : ");
                    int energy = scanner.nextInt();
                    arrPlayers.add(new Player(name, hitPoint, damage, energy));
                    System.out.println("New Player added Successful named " + name + "\n");
                    break;
                case 2:
                    if (arrPlayers.isEmpty()) {
                        System.out.println("No players available to hit boss!");
                        break;
                    }
                    System.out.println("Choose your Character  :");
                    int index = 1;
                    for (Player player : arrPlayers) {
                        System.out.printf("%d. %-15s%n", index, player.getName());
                        System.out.printf("Hit Point      : %-10d%n", player.getHitPoint());
                        System.out.printf("Damage         : %-10d%n", player.getDamage());
                        System.out.printf("Energy         : %-10d%n", player.getEnergy());
                        System.out.println("-------------------------------------------");
                        index++;
                    }
                    System.out.print("Silahkan pilih nomor Character: ");
                    int playerChoice = scanner.nextInt();
                    Player selectedPlayer = arrPlayers.get(playerChoice - 1);

                    if (selectedPlayer.getEnergy() <= 0) {
                        System.out.println("Energy Player habis, tidak bisa digunakan lagi!");
                    } else {
                        boss.registerBattleLog(report);
                        boss.onDamageApplied(selectedPlayer);

                        if (selectedPlayer.getEnergy() <= 0) {
                            System.out.println(
                                    "Energy Player " + selectedPlayer.getName() + " habis, tidak bisa digunakan lagi!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Sayonara");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
