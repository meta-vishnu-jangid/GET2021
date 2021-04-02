var VehiclePass = /** @class */ (function () {
    function VehiclePass(vehicleType, duration, totalPrice) {
        this.time = new Date();
        this.vehicleType = vehicleType;
        this.duration = duration;
        this.totalPrice = totalPrice;
    }
    return VehiclePass;
}());
