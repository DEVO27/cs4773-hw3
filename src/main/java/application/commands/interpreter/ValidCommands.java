package application.commands.interpreter;

public enum ValidCommands {
    CREATE_RECTANGLE("CREATE RECTANGLE"),
    CREATE_CIRCLE("CREATE CIRCLE"),
    DRAW_SCENE("DRAWSCENE"),
    SELECT("SELECT"),
    DELETE("DELETE"),
    COLOR("COLOR"),
    MOVE("MOVE"),
    UNDO("UNDO"),
    DRAW("DRAW");
    public final String label;

    private ValidCommands(String label) {
        this.label = label;
    }
}
