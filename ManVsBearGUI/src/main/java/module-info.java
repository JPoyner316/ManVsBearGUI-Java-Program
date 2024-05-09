module edu.arapahoe.csc1060.mvb.gui.manvsbeargui {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.arapahoe.csc1060.mvb.gui.manvsbeargui to javafx.fxml;
    exports edu.arapahoe.csc1060.mvb.gui.manvsbeargui;
}