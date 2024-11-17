import {Survivor} from "./survivor";
import {SafeHouse} from "./safeHouse";
import { getRandomSurvivor } from "../utils/helpers";

//a function that allows the user to assign tasks for a survivor to do through a day
export function assignTasks(survivors: Survivor[]) {
    for (const survivor of survivors) {
        if (survivor.health > 0) {
            // ask for a task
            // assign it to the survivor with survivor.assignTask(task: string)
        } else {
            console.log(`${survivor.name} is dead`);
        }
    }
}

// a function that allows the user to view the inventory of any single survivor
export function viewInventory(survivors: Survivor[]) {
    for (const survivor of survivors) {
        if (survivor.health > 0) {

            survivor.inventory.forEach((value, key) => {
                console.log(`${key}: ${value}`);
            });
        } else {
            console.log(`${survivor.name} is dead`);
        }
    }
}

// this function allows the user to see the stats of any single survivor
export function viewSurvivorStatus(survivors: Survivor[]) {
    for (const survivor of survivors) {
        if (survivor.health > 0) {
            // use console.log to show the name and stats of the survivor

        } else {
            console.log(`${survivor.name} is dead`);
        }
    }
}

// this function iterates through a single day, acting on the survivors tasks, displaying if they are dead, and then getting a random event
export function executeDay(safeHouse: SafeHouse, survivors: Survivor[]) {

    for (const survivor of survivors) {
        if (survivor.health > 0) {
            // act on their task

        } else {
            console.log(`${survivor.name} is dead`);
        }
    }

    // do a random event that affects either the safehouse or a random survivor
    let randomSurvivor = getRandomSurvivor(survivors);
    if (randomSurvivor) {
        // get some kind of event and apply to randomSurvivor
    }
}