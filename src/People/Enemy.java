package People;

public class Enemy extends Person {
    public static Enemy[] enemies;
    private int attack;

    public Enemy(String name, int xLoc, int yLoc, int HP, int maxHP, int attack) {
        super(name, xLoc, yLoc, HP, maxHP);
        this.attack = attack;

        if (enemies == null)
            enemies = new Enemy[]{this};
        else {
            Enemy[] newEnemies = new Enemy[enemies.length + 1];
            for (int i = 0; i < enemies.length; i++)
                newEnemies[i] = enemies[i];
            newEnemies[enemies.length] = this;
            enemies = newEnemies;
        }
    }
}
