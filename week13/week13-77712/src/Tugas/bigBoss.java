package Tugas;

public class bigBoss {
    private int hitPoint;
    private int damageReduction;
    private int damageTaken;
    private BattleLog report;

    public bigBoss() {
        this.hitPoint = 1000;
        this.damageReduction = 10;
        this.damageTaken = 0;
    }

    public void registerBattleLog(BattleLog report) {
        this.report = report;
    }

    public void onDamageApplied(Player player) {
        int damageGivenToBoss = player.getDamage() - damageReduction;
        if (damageGivenToBoss < 0) {
            damageGivenToBoss = 0;
        }

        hitPoint -= damageGivenToBoss;
        damageTaken += damageGivenToBoss;

        player.setHitPoint(player.getHitPoint() - damageReduction);
        player.setEnergy(player.getEnergy() - 10);

        if (report != null) {
            report.reportBattle(player, damageGivenToBoss, hitPoint);
        }
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }
}
