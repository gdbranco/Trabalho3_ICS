import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;
import javax.swing.JButton;

import sintese.*;

public class Interface extends JFrame {
	private int NOTE_ON = 144;
	private int NOT_OFF = 128;
	private ArrayList<String> lista;
	private double A0 = 0.7;
	private int T = 20;
	private int F0 = 220;
	private static final long serialVersionUID = 1L;
	private Envoltoria fade_in, fade_out;
	private File midi=null;
	private JPanel contentPane;
	private void setFade_in()
	{
		Curva c_fadein = new Curva(512);
		c_fadein.addPonto(0, 0);
		c_fadein.addPonto(512, 5000);
		fade_in = new Envoltoria(c_fadein);
	}
	private Envoltoria getFade_in()
	{
		return this.fade_in;
	}
	private void setFade_out()
	{
		Curva c_fadein = new Curva(512);
		c_fadein.addPonto(0, 5000);
		c_fadein.addPonto(512, 0);
		fade_out = new Envoltoria(c_fadein);
	}
	private Envoltoria getFade_out()
	{
		return this.fade_out;
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
	public void getTone()
	{
		setFade_out();
		setFade_in();
		Oscilador osc = new Oscilador(fade_out);
		Oscilador osc2 = new Oscilador(fade_in);
		LinkedList<Nota> lista_notas = new LinkedList<Nota>();
		lista_notas.add(new Nota(1f, 880f, 33f));
		lista_notas.add(new Nota(1f, 825f, 33f));
		lista_notas.add(new Nota(1f, 770f, 33f));
		lista_notas.add(new Nota(1f, 715f, 33f));
		lista_notas.add(new Nota(1f, 660f, 33f));
		lista_notas.add(new Nota(1f, 605f, 33f));
		lista_notas.add(new Nota(1f, 495f, 33f));
		lista_notas.add(new Nota(1f, 440f, 33f));
		Melodia melodia = new Melodia(lista_notas);
		//
		LinkedList<Nota> lista_notasr = new LinkedList<Nota>();
		lista_notasr.add(new Nota(1f, 440f, 33f));
		lista_notasr.add(new Nota(1f, 495f, 33f));
		lista_notasr.add(new Nota(1f, 605f, 33f));
		lista_notasr.add(new Nota(1f, 660f, 33f));
		lista_notasr.add(new Nota(1f, 715f, 33f));
		lista_notasr.add(new Nota(1f, 770f, 33f));
		lista_notasr.add(new Nota(1f, 880f, 33f));
		lista_notasr.add(new Nota(1f, 825f, 33f));
		Melodia melodiar = new Melodia(lista_notasr);
		LinkedList<Nota> lista_notas2 = new LinkedList<Nota>();
		//lista_notas2.add(new Nota(1f, 440f, 33f));
		lista_notas2.add(new Nota(1f, 412,5f, 33f));
		lista_notas2.add(new Nota(1f, 385f, 33f));
		lista_notas2.add(new Nota(1f, 357,5f, 33f));
		lista_notas2.add(new Nota(1f, 330f, 33f));
		lista_notas2.add(new Nota(1f, 302,5f, 33f));
		lista_notas2.add(new Nota(1f, 275f, 33f));
		lista_notas2.add(new Nota(1f, 247,5f, 33f));
		lista_notas2.add(new Nota(1f, 220f, 33f));
		Melodia melodia2 = new Melodia(lista_notas2);
		//
		LinkedList<Nota> lista_notas2r = new LinkedList<Nota>();
		lista_notas2r.add(new Nota(1f, 220f, 33f));
		lista_notas2r.add(new Nota(1f, 247,5f, 33f));
		lista_notas2r.add(new Nota(1f, 275f, 33f));
		lista_notas2r.add(new Nota(1f, 302,5f, 33f));
		lista_notas2r.add(new Nota(1f, 330f, 33f));
		lista_notas2r.add(new Nota(1f, 357,5f, 33f));
		lista_notas2r.add(new Nota(1f, 385f, 33f));
		lista_notas2r.add(new Nota(1f, 412,5f, 33f));
		Melodia melodia2r = new Melodia(lista_notas2r);
		LinkedList<Nota> lista_notas3 = new LinkedList<Nota>();
		//lista_notas3.add(new Nota(1f, 220f, 33f));
		lista_notas3.add(new Nota(1f, 206,25f, 33f));
		lista_notas3.add(new Nota(1f, 192,5f, 33f));
		lista_notas3.add(new Nota(1f, 178,75f, 33f));
		lista_notas3.add(new Nota(1f, 165f, 33f));
		lista_notas3.add(new Nota(1f, 151,25f, 33f));
		lista_notas3.add(new Nota(1f, 137,5f, 33f));
		lista_notas3.add(new Nota(1f, 123,75f, 33f));
		lista_notas3.add(new Nota(1f, 110f, 33f));
		Melodia melodia3 = new Melodia(lista_notas3);
		//
		LinkedList<Nota> lista_notas3r = new LinkedList<Nota>();
		lista_notas3r.add(new Nota(1f, 110f, 33f));
		lista_notas3r.add(new Nota(1f, 123,75f, 33f));
		lista_notas3r.add(new Nota(1f, 137,5f, 33f));
		lista_notas3r.add(new Nota(1f, 151,25f, 33f));
		lista_notas3r.add(new Nota(1f, 165f, 33f));
		lista_notas3r.add(new Nota(1f, 178,75f, 33f));
		lista_notas3r.add(new Nota(1f, 192,5f, 33f));
		lista_notas3r.add(new Nota(1f, 206,25f, 33f));
		Melodia melodia3r = new Melodia(lista_notas3r);
		LinkedList<Nota> lista_notas4 = new LinkedList<Nota>();
		//lista_notas3.add(new Nota(1f, 220f, 33f));
		lista_notas4.add(new Nota(1f, 103,125f, 33f));
		lista_notas4.add(new Nota(1f, 96,25f, 33f));
		lista_notas4.add(new Nota(1f, 89,375f, 33f));
		lista_notas4.add(new Nota(1f, 82,5f, 33f));
		lista_notas4.add(new Nota(1f, 75,625f, 33f));
		lista_notas4.add(new Nota(1f, 68,75f, 33f));
		lista_notas4.add(new Nota(1f, 61,875f, 33f));
		lista_notas4.add(new Nota(1f, 55f, 33f));
		Melodia melodia4 = new Melodia(lista_notas4);
		//
		LinkedList<Nota> lista_notas4r = new LinkedList<Nota>();
		//lista_notas3.add(new Nota(1f, 220f, 33f));
		lista_notas4r.add(new Nota(1f, 55f, 33f));
		lista_notas4r.add(new Nota(1f, 61,875f, 33f));
		lista_notas4r.add(new Nota(1f, 68,75f, 33f));
		lista_notas4r.add(new Nota(1f, 75,625f, 33f));
		lista_notas4r.add(new Nota(1f, 82,5f, 33f));
		lista_notas4r.add(new Nota(1f, 89,375f, 33f));
		lista_notas4r.add(new Nota(1f, 96,25f, 33f));
		lista_notas4r.add(new Nota(1f, 103,125f, 33f));
		Melodia melodia4r = new Melodia(lista_notas4r);
		Voz voz = new Voz(osc);
		voz.addMelodia(melodia);
		voz.addMelodia(melodia2);
		voz.addMelodia(melodia3);
		voz.addMelodia(melodia4);
		Voz voz2 = new Voz(osc2);
		voz2.addMelodia(melodia4r);
		voz2.addMelodia(melodia3r);
		voz2.addMelodia(melodia2r);
		voz2.addMelodia(melodiar);
		//voz2.getSom().visualiza();
		//voz.getSom().visualiza();
		Polifonia poli = new Polifonia();
		poli.addVoz(voz);
		poli.addVoz(voz2);
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
	private void inicia_lista()
	{
		lista.add("0C");lista.add("0C#");lista.add("0D");lista.add("0D#");lista.add("0E");lista.add("0E#");lista.add("0F");lista.add("0F#");lista.add("0G");lista.add("0G#");lista.add("0A");lista.add("0A#");lista.add("0B");
		lista.add("1C");lista.add("1C#");lista.add("1D");lista.add("1D#");lista.add("1E");lista.add("1E#");lista.add("1F");lista.add("1F#");lista.add("1G");lista.add("1G#");lista.add("1A");lista.add("1A#");lista.add("1B");
		lista.add("2C");lista.add("2C#");lista.add("2D");lista.add("2D#");lista.add("2E");lista.add("2E#");lista.add("0F");lista.add("2F#");lista.add("2G");lista.add("2G#");lista.add("2A");lista.add("2A#");lista.add("2B");
		lista.add("3C");lista.add("3C#");lista.add("3D");lista.add("3D#");lista.add("3E");lista.add("3E#");lista.add("0F");lista.add("3F#");lista.add("3G");lista.add("3G#");lista.add("3A");lista.add("3A#");lista.add("3B");
		lista.add("4C");lista.add("4C#");lista.add("4D");lista.add("4D#");lista.add("4E");lista.add("4E#");lista.add("0F");lista.add("4F#");lista.add("4G");lista.add("4G#");lista.add("4A");lista.add("4A#");lista.add("4B");
		lista.add("5C");lista.add("5C#");lista.add("5D");lista.add("5D#");lista.add("5E");lista.add("5E#");lista.add("0F");lista.add("5F#");lista.add("5G");lista.add("5G#");lista.add("5A");lista.add("5A#");lista.add("5B");
		lista.add("6C");lista.add("6C#");lista.add("6D");lista.add("6D#");lista.add("6E");lista.add("6E#");lista.add("0F");lista.add("6F#");lista.add("6G");lista.add("6G#");lista.add("6A");lista.add("6A#");lista.add("6B");
		lista.add("7C");lista.add("7C#");lista.add("7D");lista.add("7D#");lista.add("7E");lista.add("7E#");lista.add("0F");lista.add("7F#");lista.add("7G");lista.add("7G#");lista.add("7A");lista.add("7A#");lista.add("7B");
		lista.add("8C");lista.add("8C#");lista.add("8D");lista.add("8D#");lista.add("8E");lista.add("8E#");lista.add("0F");lista.add("8F#");lista.add("8G");lista.add("8G#");lista.add("8A");lista.add("8A#");lista.add("8B");
		lista.add("9C");lista.add("9C#");lista.add("9D");lista.add("9D#");lista.add("9E");lista.add("9E#");lista.add("9F");lista.add("9F#");lista.add("9G");lista.add("9G#");lista.add("9A");lista.add("9A#");lista.add("9B");
		lista.add("10C");lista.add("10C#");lista.add("10D");lista.add("10D#");lista.add("10E");lista.add("10E#");lista.add("10F");lista.add("10F#");lista.add("10G");
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
