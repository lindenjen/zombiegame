import {Zombie} from "./zombie";

//class that sets the survivor variables and information
export class Survivor {
    public inventory: Map<string, number>;
    public taskName: string | null;

    constructor(
        public name: string,
        public strength: number,
        public health: number,      // if 0 = dead
        public morale: number,
        inventory: [string, number][]
    ) {
        this.inventory = new Map(inventory);
        this.taskName = null;
    }

    assignTask(task: string) {
        this.taskName = task;
    }
    encounterZombie(zombie: Zombie) {
        console.log(`${this.name} encountered a zombie!`);
    }
}
