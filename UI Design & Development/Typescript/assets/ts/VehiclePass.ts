class VehiclePass {

    public time: Date;
    public vehicleType: String;
    public duration: String;
    public totalPrice: Number;

    public constructor(vehicleType: String, duration: String, totalPrice: Number) {
        this.time = new Date();
        this.vehicleType = vehicleType;
        this.duration = duration;
        this.totalPrice = totalPrice;
    }
}