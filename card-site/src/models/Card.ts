export class Card {
    id: number;
    name: string;
    description: string;
    price: number;
    affinity: string;
    energy: number;
    hp: number;
    img: string;

    constructor(id: number, name: string, description: string, price: number, affinity: string, energy: number, hp: number, img: string) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.affinity = affinity;
        this.energy = energy;
        this.hp = hp;
        this.img = img;
    }

}