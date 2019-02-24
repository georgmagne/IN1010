class IkkeMerPlassException extends Exception {
    public IkkeMerPlassException (String id) {
        super("Det var ikke plass til aa sette inn " + id);
    }
}
