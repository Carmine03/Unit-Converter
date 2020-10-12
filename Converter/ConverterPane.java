package Converter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ConverterPane extends BorderPane {
	
	private String title = "Converter";
	private Label titleL;
	
	private String from = "From:";
	private Label fromL;
	private String to = "To:";
	private Label toL;
	
	private ComboBox<String> pane1;
	private ComboBox<String> pane2;
	private ArrayList<String> options = new ArrayList<>();
	
	protected TextField textIn;
	protected TextField textOut;
		
	private String btnMsg = "Convert";
	protected Button button;

	private HBox hbox1;
	private HBox hbox2;
	private VBox vbox1;
	private VBox vbox2;
	private HBox hbox;
	
	private static Font titleFont = new Font(16);
	private static Font font = new Font(14);
	private static Font smallFont = new Font(12);
	private int spacing = 10;
	private Insets insets;

	private String pattern = "###,###.#########";
	protected DecimalFormat df = new DecimalFormat(pattern);
	
	public ConverterPane() {		
		titleL = new Label(title);
		fromL = new Label(from);
		toL = new Label(to);
		button = new Button(btnMsg);
		textIn = new TextField();
		textIn.setPromptText("Enter a value");
		textOut = new TextField();
		textOut.setPromptText("Output value");
		
		pane1 = new ComboBox<>();
		pane2 = new ComboBox<>();

		pane1.getItems().addAll(options);
		
		pane2.getItems().addAll(options);
		
		hbox1 = new HBox(fromL, pane1);			
		hbox2 = new HBox(toL, pane2);
		
		vbox1 = new VBox(hbox1, textIn);
		vbox2 = new VBox(hbox2, textOut);
		
		hbox = new HBox(vbox1, vbox2);
		
		applyStyles();
		
		setTop(titleL);
		setCenter(hbox);
		setBottom(button);
	}
	
	public void setTitle(String newTitle) {
		title = newTitle;
		titleL.setText(title);
	}
	
	public void setOptions(String... strings) {
		options.addAll(Arrays.asList(strings));
		pane1.getItems().setAll(options);
		pane1.setValue(options.get(0));
		pane2.getItems().setAll(options);		
		pane2.setValue(options.get(1));
	}
	
	public String getFromUnit() {
		String unit = pane1.getValue(); 
		return unit.substring(0, unit.indexOf(" "));
	}
	
	public String getToUnit() {
		String unit = pane2.getValue(); 
		return unit.substring(0, unit.indexOf(" "));
	}
	
	public String getValueFrom() {
		return textIn.getText();
	}
	
	private void applyStyles() {
		int minSize = 280, maxSize = 30;
		textIn.setMinSize(minSize, maxSize);
		textOut.setMinSize(minSize, maxSize);
		textOut.setEditable(false);
		
		hbox1.setAlignment(Pos.CENTER);
		hbox1.setSpacing(spacing);
		hbox2.setAlignment(Pos.CENTER);
		hbox2.setSpacing(spacing);
		
		vbox1.setSpacing(spacing);
		vbox2.setSpacing(spacing);
		
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(spacing);
		
		setAlignment(titleL, Pos.CENTER);		
		setAlignment(button, Pos.CENTER);
		
		insets = new Insets(spacing);
		setMargin(titleL, insets);
		setMargin(button, insets);
		
		titleL.setFont(titleFont);		
		fromL.setFont(font);
		toL.setFont(font);
		button.setFont(font);
		pane1.setStyle("-fx-font-size: " + font.getSize());
		pane2.setStyle("-fx-font-size: " + font.getSize());
		textIn.setFont(smallFont);
		textOut.setFont(smallFont);
	}
}
