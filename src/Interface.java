import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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
	private Vector lista = null;
	private static final long serialVersionUID = 1L;

	private File midi=null;

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public Interface() {
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
			for(int i=0;i<n_trilhas;i++)
			{
				System.in.read();
				int n_eventos = trilhas[i].size();
				System.out.println("Quantidade de eventos na trilha " + i + ": " + n_eventos);
				for(int j=0;j<n_eventos;j++)
				{
					MidiEvent e = trilhas[i].get(j);
					MidiMessage msg = e.getMessage();
					float divtype = s.getDivisionType();
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
