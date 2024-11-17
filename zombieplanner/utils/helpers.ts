import {Survivor} from "../classes/survivor";

//future use function for a random integer
export function getRandomInt(min: number, max: number): number {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}
//randomly picks a random survivor
export function getRandomSurvivor(survivors: Survivor[]): Survivor | null {
    // Filter survivors to only include those with health > 0
    const aliveSurvivors = survivors.filter(survivor => survivor.health > 0);

    // If no survivors have health > 0, return null
    if (aliveSurvivors.length === 0) {
        return null;
    }

    // Pick a random survivor from the filtered list
    const randomIndex = Math.floor(Math.random() * aliveSurvivors.length);
    return aliveSurvivors[randomIndex];
}