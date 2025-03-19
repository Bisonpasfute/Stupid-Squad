package com.stupidsquad.webapp.model;

public enum ClassEnum {
    WARRIOR_ARMS("Arms"),
    WARRIOR_FURY("Fury"),
    WARRIOR_PROTECTION("Protection"),
    MONK_BREWMASTER("Brewmaster"),
    MONK_MISTWEAVER("Mistweaver"),
    MONK_WINDWALKER("Windwalker"),
    DRUID_BALANCE("Balance"),
    DRUID_FERAL("Feral"),
    DRUID_RESTORATION("Restoration"),
    DRUID_GUARDIAN("Guardian"),
    PALADIN_HOLY1("Holy1"),
    PALADIN_RETRIBUTION("Retribution"),
    PALADIN_PROTECTION("Protection1"),
    ROGUE_ASSASSINATION("Assassination"),
    ROGUE_COMBAT("Combat"),
    ROGUE_SUBTLETY("Subtlety"),
    HUNTER_BEASTMASTERY("Beastmastery"),
    HUNTER_MARKSMANSHIP("Marksmanship"),
    HUNTER_SURVIVAL("Survival"),
    MAGE_ARCANE("Arcane"),
    MAGE_FIRE("Fire"),
    MAGE_FROST("Frost"),
    WARLOCK_AFFLICTION("Affliction"),
    WARLOCK_DEMONOLOGY("Demonology"),
    WARLOCK_DESTRUCTION("Destruction"),
    PRIEST_HOLY("Holy"),
    PRIEST_DISCIPLINE("Discipline"),
    PRIEST_SHADOW("Shadow"),
    SHAMAN_ELEMENTAL("Elemental"),
    SHAMAN_ENHANCEMENT("Enhancement"),
    SHAMAN_RESTORATION("RESTORATION"),
    LATE("Late"),
    BENCH("Bench"),
    TENTATIVE("Tentative"),
    ABSENCE("Absence");

    private String className;

    ClassEnum(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
