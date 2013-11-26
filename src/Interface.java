import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;


import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.JButton;

import sintese.*;

public class Interface extends JFrame {
	private int NOTE_ON = 144;
	private int NOT_OFF = 128;
	private double A0 = 0.7;
	private int T = 20;
	private int F0 = 220;
	private static final long serialVersionUID = 1L;
	InstrumentoAditivo Ins1;
	private File midi=null;
	private JPanel contentPane;
	private Envoltoria setFade_in()
	{
		Curva c_fadein = new Curva(512);
		//c_fadein.addPonto(0, 0);
		c_fadein.addPonto(64, 2500);
		c_fadein.addPonto(128, 5000);
		c_fadein.addPonto(384, 5000);
		c_fadein.addPonto(412, 2500);
		//c_fadein.addPonto(511, 0);
		Envoltoria fade_in = new Envoltoria(c_fadein);
		return fade_in;
	}
	private Envoltoria setFade_out()
	{
		Curva c_fadein = new Curva(512);
		c_fadein.addPonto(120, 10000);
		c_fadein.addPonto(512, 1000);
		Envoltoria fade_out = new Envoltoria(c_fadein);
		return fade_out;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void prepara_Instrumentos()
	{
		Envoltoria fade_out = setFade_out();
		Envoltoria fade_in = setFade_in();
		Oscilador osc_default = new Oscilador();
		UnidadeH uH1 = new UnidadeH(osc_default, fade_in);
		UnidadeH uH2 = new UnidadeH(osc_default, fade_out);
		Ins1 = new InstrumentoAditivo();
		Ins1.addUnidade(uH2);
		Ins1.addUnidade(uH1);
	}
	public void getTone()
	{
		prepara_Instrumentos();
		//
		LinkedList<Float> frequencias1 = new LinkedList<Float>();
		frequencias1.add(new Float(130.83));
		frequencias1.add(new Float(138.59));
		frequencias1.add(new Float(146.832));
		frequencias1.add(new Float(155.56));//D#3
		frequencias1.add(new Float(164.814));
		frequencias1.add(new Float(174.614));
		frequencias1.add(new Float(185.00));//F#3
		frequencias1.add(new Float(195.998));
		frequencias1.add(new Float(207.65));//G#3
		frequencias1.add(new Float(220));
		frequencias1.add(new Float(233.08));//A#3
		frequencias1.add(new Float(246.942));
		
		LinkedList<Float> volumes1 = new LinkedList<Float>();
		volumes1.add(new Float(1));
		volumes1.add(new Float(0.96));
		volumes1.add(new Float(0.92));
		volumes1.add(new Float(0.88));
		volumes1.add(new Float(0.84));
		volumes1.add(new Float(0.80));
		volumes1.add(new Float(0.75));
		volumes1.add(new Float(0.71));
		volumes1.add(new Float(0.67));
		volumes1.add(new Float(0.63));
		volumes1.add(new Float(0.59));
		volumes1.add(new Float(0.55));
		//
		LinkedList<Float> frequencias2 = new LinkedList<Float>();
		frequencias2.add(new Float(261.63));
		frequencias2.add(new Float(69.30));
		frequencias2.add(new Float(73.42));
		frequencias2.add(new Float(77.78));
		frequencias2.add(new Float(82.41));
		frequencias2.add(new Float(87.31));
		frequencias2.add(new Float(185.00));
		frequencias2.add(new Float(98.00));
		frequencias2.add(new Float(103.83));
		frequencias2.add(new Float(110.00));
		frequencias2.add(new Float(116.54));
		frequencias2.add(new Float(123.47));
		
		LinkedList<Float> volumes2 = new LinkedList<Float>();
		volumes2.add(new Float(0.5));
		volumes2.add(new Float(0.54));
		volumes2.add(new Float(0.58));
		volumes2.add(new Float(0.62));
		volumes2.add(new Float(0.66));
		volumes2.add(new Float(0.70));
		volumes2.add(new Float(0.75));
		volumes2.add(new Float(0.79));
		volumes2.add(new Float(0.83));
		volumes2.add(new Float(0.87));
		volumes2.add(new Float(0.91));
		volumes2.add(new Float(0.95));
		//
		LinkedList<Float> frequencias3 = new LinkedList<Float>();
		frequencias3.add(new Float(261.63));
		frequencias3.add(new Float(277.18));
		frequencias3.add(new Float(293.66));
		frequencias3.add(new Float(311.13));
		frequencias3.add(new Float(329.63));
		frequencias3.add(new Float(349.23));
		frequencias3.add(new Float(369.99));
		frequencias3.add(new Float(392.00));
		frequencias3.add(new Float(415.30));
		frequencias3.add(new Float(440.00));
		frequencias3.add(new Float(466.16));
		frequencias3.add(new Float(493.88));
		
		LinkedList<Float> volumes3 = new LinkedList<Float>();
		volumes3.add(new Float(0.5));
		volumes3.add(new Float(0.46));
		volumes3.add(new Float(0.42));
		volumes3.add(new Float(0.38));
		volumes3.add(new Float(0.34));
		volumes3.add(new Float(0.30));
		volumes3.add(new Float(0.25));
		volumes3.add(new Float(0.21));
		volumes3.add(new Float(0.17));
		volumes3.add(new Float(0.13));
		volumes3.add(new Float(0.09));
		volumes3.add(new Float(0.05));
		//
		LinkedList<Float> frequencias4 = new LinkedList<Float>();
		frequencias4.add(new Float(32.70));
		frequencias4.add(new Float(34.65));
		frequencias4.add(new Float(36.71));
		frequencias4.add(new Float(38.89));
		frequencias4.add(new Float(41.20));
		frequencias4.add(new Float(43.65));
		frequencias4.add(new Float(369.99));
		frequencias4.add(new Float(49.00));
		frequencias4.add(new Float(51.91));
		frequencias4.add(new Float(55.00));
		frequencias4.add(new Float(58.27));
		frequencias4.add(new Float(61.74));
		
		LinkedList<Float> volumes4 = new LinkedList<Float>();
		volumes4.add(new Float(0));
		volumes4.add(new Float(0.04));
		volumes4.add(new Float(0.08));
		volumes4.add(new Float(0.12));
		volumes4.add(new Float(0.16));
		volumes4.add(new Float(0.20));
		volumes4.add(new Float(0.25));
		volumes4.add(new Float(0.29));
		volumes4.add(new Float(0.33));
		volumes4.add(new Float(0.37));
		volumes4.add(new Float(0.41));
		volumes4.add(new Float(0.45));
		//
		LinkedList<Nota> notas1 = new LinkedList<Nota>();
		LinkedList<Nota> notas2 = new LinkedList<Nota>();
		LinkedList<Nota> notas3 = new LinkedList<Nota>();
		LinkedList<Nota> notas4 = new LinkedList<Nota>();
		int i=0;
		for(int j=0;j<120;j++)
		{
			if((j%12)==0)
			{
				i=0;
			}
			notas1.add(new Nota(1f,frequencias1.get(i),volumes1.get(i)*66));
			notas2.add(new Nota(1f,frequencias2.get(i),volumes2.get(i)*66));
			notas3.add(new Nota(1f,frequencias3.get(i),volumes3.get(i)*66));
			notas4.add(new Nota(1f,frequencias4.get(i),volumes4.get(i)*66));
			i++;
		}
		//
		Melodia melodia1 = new Melodia(notas1);
		Melodia melodia2 = new Melodia(notas2);
		Melodia melodia3 = new Melodia(notas3);
		Melodia melodia4 = new Melodia(notas4);
		//
		Voz voz1 = new Voz(Ins1);
		voz1.addMelodia(melodia1);
		Voz voz2 = new Voz(Ins1);
		voz2.addMelodia(melodia2);
		Voz voz3 = new Voz(Ins1);
		voz3.addMelodia(melodia3);
		Voz voz4 = new Voz(Ins1);
		voz4.addMelodia(melodia4);
		//
		Voz voz1r = new Voz(Ins1);
		voz1r.addMelodia(melodia1.inversao());
		Voz voz2r = new Voz(Ins1);
		voz2r.addMelodia(melodia2.inversao());
		Voz voz3r = new Voz(Ins1);
		voz3r.addMelodia(melodia3.inversao());
		Voz voz4r = new Voz(Ins1);
		voz4r.addMelodia(melodia4.inversao());
		//
		Polifonia poli = new Polifonia();
		poli.addVoz(voz1);
		poli.addVoz(voz2);
		poli.addVoz(voz3);
		poli.addVoz(voz4);
		//
		/*poli.addVoz(voz4r);
		poli.addVoz(voz3r);
		poli.addVoz(voz2r);
		poli.addVoz(voz1r);*/
		poli.setAndamento(0.5f);
		poli.setGanho(0.01f);
		poli.getSom().visualiza();
	}
	//Para t E [0,T[
	private double fS(double t)
	{
		return fA(t)*Math.sin(fW(t)*t)+fA(t+T)*Math.sin(2*fW(t)*t);
	}
	private double fA(double t)
	{
		return A0*((1+Math.cos(Math.PI)*t/T)/4);
	}
	private double fW(double t)
	{
		return 2*Math.PI*F0*(1/Math.pow(2, t/T));
	}
	private float numNote_freq(int numNote)
	{
		float freq=0;
		switch(numNote)
		{
		case 0:
			freq = (float) 8.18;
			break;
		case 1:
			freq = (float) 8.66;
			break;
		case 2:
			freq = (float) 9.18;
			break;
		case 3:
			freq = (float) 9.73;
			break;
		case 4:
			freq = (float) 10.30;
			break;
		case 5:
			freq = (float) 10.92;
			break;
		case 6:
			freq = (float) 11.56;
			break;
		case 7:
			freq = (float) 12.25;
			break;
		case 8:
			freq = (float) 12.98;
			break;
		case 9:
			freq = (float) 13.75;
			break;
		case 10:
			freq = (float) 14.57;
			break;
		case 11:
			freq = (float) 15.44;
			break;
		case 12:
			freq = (float) 16.35;
			break;
		case 13:
			freq = (float) 17.32;
			break;
		case 14:
			freq = (float) 18.35;
			break;
		case 15:
			freq = (float) 19.45;
			break;
		case 16:
			freq = (float) 20.60;
			break;
		case 17:
			freq = (float) 21.83;
			break;
		case 18:
			freq = (float) 23.12;
			break;
		case 19:
			freq = (float) 24.50;
			break;
		case 20:
			freq = (float) 25.95;
			break;
		case 21:
			freq = (float) 27.50;
			break;
		case 22:
			freq = (float) 29.14;
			break;
		case 23:
			freq = (float) 30.87;
			break;
		case 24:
			freq = (float) 32.70;
			break;
		case 25:
			freq = (float) 34.65;
			break;
		case 26:
			freq = (float) 36.71;
			break;
		case 27:
			freq = (float) 38.89;
			break;
		case 28:
			freq = (float) 41.20;
			break;
		case 29:
			freq = (float) 43.65;
			break;
		case 30:
			freq = (float) 46.25;
			break;
		case 31:
			freq = (float) 49.00;
			break;
		case 32:
			freq = (float) 51.91;
			break;
		case 33:
			freq = (float) 55.00;
			break;
		case 34:
			freq = (float) 58.27;
			break;
		case 35:
			freq = (float) 61.74;
			break;
		case 36:
			freq = (float) 65.41;
			break;
		case 37:
			freq = (float) 69.30;
			break;
		case 38:
			freq = (float) 73.42;
			break;
		case 39:
			freq = (float) 77.78;
			break;
		case 40:
			freq = (float) 82.41;
			break;
		case 41:
			freq = (float) 87.31;
			break;
		case 42:
			freq = (float) 92.50;
			break;
		case 43:
			freq = (float) 98.00;
			break;
		case 44:
			freq = (float) 103.83;
			break;
		case 45:
			freq = (float) 110.00;
			break;
		case 46:
			freq = (float) 116.54;
			break;
		case 47:
			freq = (float) 123.47;
			break;
		case 48:
			freq = (float) 130.81;
			break;
		case 49:
			freq = (float) 138.59;
			break;
		case 50:
			freq = (float) 146.83;
			break;
		case 51:
			freq = (float) 155.56;
			break;
		case 52:
			freq = (float) 164.81;
			break;
		case 53:
			freq = (float) 174.61;
			break;
		case 54:
			freq = (float) 185.00;
			break;
		case 55:
			freq = (float) 196.00;
			break;
		case 56:
			freq = (float) 207.65;
			break;
		case 57:
			freq = (float) 220.00;
			break;
		case 58:
			freq = (float) 233.88;
			break;
		case 59:
			freq = (float) 246.94;
			break;
		case 60:
			freq = (float) 261.63;//Middle C
			break;
		case 61:
			freq = (float) 277.18;
			break;
		case 62:
			freq = (float) 293.66;
			break;
		case 63:
			freq = (float) 311.13;
			break;
		case 64:
			freq = (float) 329.63;
			break;
		case 65:
			freq = (float) 349.23;
			break;
		case 66:
			freq = (float) 369.99;
			break;
		case 67:
			freq = (float) 392.00;
			break;
		case 68:
			freq = (float) 415.30;	
			break;
		case 69:
			freq = (float) 440.00;//Tuning A
			break;
		case 70:
			freq = (float) 466.16;
			break;
		case 71:
			freq = (float) 493.88;
			break;
		case 72:
			freq = (float) 523.25;
			break;
		case 73:
			freq = (float) 554.36;
			break;
		case 74:
			freq = (float) 587.32;
			break;
		case 75:
			freq = (float) 622.26;
			break;
		case 76:
			freq = (float) 659.26;
			break;
		case 77:
			freq = (float) 698.46;
			break;
		case 78:
			freq = (float) 739.99;
			break;
		case 79:
			freq = (float) 789.99;
			break;
		case 80:
			freq = (float) 830.61;
			break;
		case 81:
			freq = (float) 880.00;
			break;
		case 82:
			freq = (float) 932.33;
			break;
		case 83:
			freq = (float) 987.77;
			break;
		case 84:
			freq = (float) 1046.50;
			break;
		case 85:
			break;
		case 86:
			break;
		case 87:
			break;
		case 88:
			break;
		case 89:
			break;
		case 90:
			break;
		case 91:
			break;
		case 92:
			break;
		case 93:
			break;
		case 94:
			break;
		case 95:
			break;
		case 96:
			break;
		case 97:
			break;
		case 98:
			break;
		case 99:
			break;
		case 100:
			break;
		case 101:
			break;
		case 102:
			break;
		case 103:
			break;
		case 104:
			break;
		case 105:
			break;
		case 106:
			break;
		case 107:
			break;
		case 108:
			break;
		case 109:
			break;
		case 110:
			break;
		case 111:
			break;
		case 112:
			break;
		case 113:
			break;
		case 114:
			break;
		case 115:
			break;
		case 116:
			break;
		case 117:
			break;
		case 118:
			break;
		case 119:
			break;
		case 120:
			break;
		case 121:
			break;
		case 122:
			break;
		case 123:
			break;
		case 124:
			break;
		case 125:
			break;
		case 126:
			break;
		case 127:
			break;
		}
		return freq;
	}
	/**
	 * Create the frame.
	 */
	public Interface() {
		//inicia_lista();
		UIManager.put("FileChooser.openDialogTitleText", "Abrir arquivo midi");
        UIManager.put("FileChooser.lookInLabelText", "Buscar em");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do arquivo");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Tipo");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir o arquivo selecionado");
        UIManager.put("FileChooser.cancelButtonToolTipText","Cancelar");
        UIManager.put("FileChooser.fileNameHeaderText","Nome");
        UIManager.put("FileChooser.upFolderToolTipText", "Subir um nível");
        UIManager.put("FileChooser.homeFolderToolTipText","Nível home");
        UIManager.put("FileChooser.newFolderToolTipText","Criar pasta");
        UIManager.put("FileChooser.listViewButtonToolTipText","Em lista");
        UIManager.put("FileChooser.newFolderButtonText","Criar pasta");
        UIManager.put("FileChooser.renameFileButtonText", "Mudar o nome");
        UIManager.put("FileChooser.deleteFileButtonText", "Deletar");
        UIManager.put("FileChooser.filterLabelText", "Extensão de arquivo");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Com detalhes");
        UIManager.put("FileChooser.fileSizeHeaderText","Tamanho");
        UIManager.put("FileChooser.fileDateHeaderText", "Data de modificação");
        UIManager.put("FileChooser.acceptAllFileFilterText", "Binário");

        UIManager.put("FileChooser.saveButtonText", "Salvar");
        UIManager.put("FileChooser.saveDialogTitleText", "Salvar em");
        UIManager.put("FileChooser.saveInLabelText", "Salvar em");
        UIManager.put("FileChooser.saveButtonToolTipText", "Salvar arquivo selecionado");

        UIManager.put("OptionPane.yesButtonText",    "Sim");
        UIManager.put("OptionPane.noButtonText",     "Não");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");

        UIManager.put("FileChooser.listFont", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("FileChooser.fileNameLabelText", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("FileChooser.filesOfTypeLabelText", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));

        UIManager.put("JSlider.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("JSlider.listFont", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("JSlider", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("JFileChooser.listFont", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("JFileChooser.fileNameLabelText", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("JFileChooser.filesOfTypeLabelText", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("JButton", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));

        UIManager.put("OptionPane.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("Button.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("RadioButton.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 10)));

        UIManager.put("Label.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("JLabel.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("JLabel", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        
        
        UIManager.put("ComboBox.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("ToolTip.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 10)));
        UIManager.put("EditorPane.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("List.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("Panel.listFont", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("Panel.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("Table.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 10)));
        UIManager.put("TextArea.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 10)));
        UIManager.put("TextField.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 10)));
        UIManager.put("TextPane.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 10)));
        UIManager.put("JTextArea.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 10)));
        UIManager.put("JTextField.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 10)));
        UIManager.put("JTextPane.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 10)));
        UIManager.put("InternalFrame.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("InternalFrame.titleFont",new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("Frame.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("Frame.titleFont",new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));
        UIManager.put("ScrollPane.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 11)));

        UIManager.put("ProgressBar.font", new javax.swing.plaf.FontUIResource(new Font("Arial", java.awt.Font.PLAIN, 10)));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAbrir = new JButton("Abrir...");
		btnAbrir.setBounds(335, 11, 89, 23);
		contentPane.add(btnAbrir);
		btnAbrir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Abrir();
			}
		});
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setBounds(222, 11, 89, 23);
		contentPane.add(btnVisualizar);
		btnVisualizar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				getTone();
			}
		});
	}
	public void Preparar()
	{
		try 
		{
			Track[] trilhas=null;
			Sequence s = null;
			s = MidiSystem.getSequence(this.getMidi());
			trilhas = s.getTracks();
			int n_trilhas = trilhas.length;
			System.out.println("Quantidade de trilhas: " + n_trilhas);
			//Provavelmente tem de se fazer um merge sort aqui
			for(int i=0;i<n_trilhas;i++)
			{
				System.in.read();
				int n_eventos = trilhas[i].size();
				System.out.println("Quantidade de eventos na trilha " + i + ": " + n_eventos);
				for(int j=0;j<n_eventos;j++)
				{
					MidiEvent e = trilhas[i].get(j);
					System.out.println("Tempo do evento "+j+": "+e.getTick());
					MidiMessage msg = e.getMessage();
					//float divtype = s.getDivisionType();
					if(msg instanceof ShortMessage)
					{
							int Command = ((ShortMessage)msg).getCommand();
							int status = ((ShortMessage)msg).getStatus();
							int data1 = ((ShortMessage)msg).getData1();
							int data2 = ((ShortMessage)msg).getData2();
							System.out.println("Data nos bytes: "+Command+" "+status+" "+data1+" "+data2);
							/*if(((ShortMessage) msg).get) == 0xFF)
							{
								byte[] data = ((MetaMessage)msg).getData();
								System.out.println("Quantidade de data no evento " +j+ ": " + data.length);
									StringBuilder sb = new StringBuilder();
								    for (byte b : data) {
								        sb.append(String.format("%02X ", b));
								    }
								    System.out.println("Data nos bytes: " + sb.toString());
							}*/
					}
				}
			}
		}
		catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*float divtype = seq.getDivisionType();
		assert (seq.getDivisionType() == Sequence.PPQ);
		Track[] tracks = seq.getTracks();
		int[] trackspos = new int[tracks.length];
		int mpq = 500000;
		int seqres = seq.getResolution();
		long lasttick = 0;
		long curtime = 0;
		while (true) {
			MidiEvent selevent = null;
			int seltrack = -1;
			for (int i = 0; i < tracks.length; i++) {
				int trackpos = trackspos[i];
				Track track = tracks[i];
				if (trackpos < track.size()) {
					MidiEvent event = track.get(trackpos);
					if (selevent == null
							|| event.getTick() < selevent.getTick()) {
						selevent = event;
						seltrack = i;
					}
				}
			}
			if (seltrack == -1)
				break;
			trackspos[seltrack]++;
			long tick = selevent.getTick();
			if (divtype == Sequence.PPQ)
				curtime += ((tick - lasttick) * mpq) / seqres;
			else
				curtime = (long) ((tick * 1000000.0 * divtype) / seqres);
			lasttick = tick;
			MidiMessage msg = selevent.getMessage();
			if (msg instanceof MetaMessage) {
				if (divtype == Sequence.PPQ)
					if (((MetaMessage) msg).getType() == 0x51) {
						byte[] data = ((MetaMessage) msg).getData();
						mpq = ((data[0] & 0xff) << 16)
								| ((data[1] & 0xff) << 8) | (data[2] & 0xff);
					}
			} else {
				if (recv != null)
					recv.send(msg, curtime);
			}
		}
		return curtime / 1000000.0;
	}*/
	}
	public void Visualizar()
	{
		
	}
	public void Abrir() {
		try {
			File arq = new File("./midis/");
			JFileChooser escolha = new JFileChooser();
			escolha.setCurrentDirectory(arq);
			escolha.setFileSelectionMode(JFileChooser.FILES_ONLY);
			escolha.setFileFilter(new FileFilter() {
				public boolean accept(File f) {
					if (!f.isFile())
						return true;
					String name = f.getName().toLowerCase();
					if (name.endsWith(".mid"))
						return true;
					return false;
				}

				public String getDescription() {
					return "Midi (*.mid)";
				}
			});
			escolha.showOpenDialog(this);
			this.setMidi(escolha.getSelectedFile());
			Preparar();
			//System.out.println(midi.getName());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public File getMidi() {
		return midi;
	}

	public void setMidi(File midi) {
		this.midi = midi;
	}
}
