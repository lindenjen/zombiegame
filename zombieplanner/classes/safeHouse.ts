//class that sets the safehouse variables and information
export class SafeHouse {
    constructor(
        public location: string,
        public securityLevel: number,
        public resources: { food: number; water: number; medicine: number }
    ) {}

    fortify() {}
    consumeResources() {}
}
