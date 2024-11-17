import {SafeHouse} from "../classes/safeHouse";
import {Survivor} from "../classes/survivor";

//function for during a day, one random event will be given each day, either will help the players run or make it more difficult
export function randomEvent(survivors: Survivor[], safeHouse: SafeHouse) {
    const eventRoll = Math.random();
    if (eventRoll < 0.3) {
        console.log("A zombie attack on the safe house!");
        safeHouse.securityLevel -= 1;
    } else if (eventRoll < 0.6) {
        console.log("Found extra supplies!");
        safeHouse.resources.food += 2;
    }
}
