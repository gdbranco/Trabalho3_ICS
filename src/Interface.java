import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sintese.Curva;
import sintese.Envoltoria;
import sintese.InstrumentoAditivo;
import sintese.Melodia;
import sintese.Nota;
import sintese.Oscilador;
import sintese.Polifonia;
import sintese.Som;
import sintese.UnidadeH;
import sintese.Voz;

public class Interface extends JFrame {
        private int andamento_atual = 100;
        private static final long serialVersionUID = 1L;
        InstrumentoAditivo Ins1;
        private final JPanel contentPane;
        private final JTextField textFAndamento;

        private Envoltoria setSustain() {
                Curva c_sustain = new Curva(512);
                c_sustain.addPonto(0, 1750);
                c_sustain.addPonto(512, 1750);
                Envoltoria sustain = new Envoltoria(c_sustain);
                return sustain;
        }

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        @Override
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

        public void prepara_Instrumentos() {
                Envoltoria sustain = setSustain();
                UnidadeH uH2 = new UnidadeH();
                uH2.setEnvoltoria(sustain);
                uH2.setLambda(0.5f);
                Oscilador osc = new Oscilador();
                osc.setFrequencia(700f);
                osc.setFase(1.2f);
                uH2.setOscilador(osc);
                Ins1 = new InstrumentoAditivo();
                Ins1.addUnidade(uH2);
        }
        public Polifonia getTone(float andamento) {
            prepara_Instrumentos();
            Melodia c1, c2, c3, c4;
            c1 = new Melodia();
            c2 = new Melodia();
            c3 = new Melodia();
            c4 = new Melodia();
            float base = 10f;
            float mult = base / frequencias1.size();
            for (int k = 0; k < 10; k++) {
                    for (int i = 0; i < frequencias1.size(); i++) {
                            c1.addNota(new Nota(.5f, frequencias1.get(i), base - (i * mult) / 2)); // 100% ~ 50%
                            c2.addNota(new Nota(.5f, frequencias2.get(i), base / 2 + ((i * mult) / 2))); // 50% ~ 100%
                            c3.addNota(new Nota(.5f, frequencias3.get(i), base / 2 - ((i * mult) / 2))); // 50% ~ 0%
                            c4.addNota(new Nota(.5f, frequencias4.get(i),0 + (i * mult) / 2)); // 0% ~ 50%
                    }
            }
            Voz v1, v2, v3, v4;
            v1 = new Voz(Ins1);
            v2 = new Voz(Ins1);
            v3 = new Voz(Ins1);
            v4 = new Voz(Ins1);
            v1.addMelodia(c1);
            v2.addMelodia(c2);
            v3.addMelodia(c3);
            v4.addMelodia(c4);
            Polifonia p1 = new Polifonia();
            p1.addVoz(v1);
            p1.addVoz(v2);
            p1.addVoz(v3);
            p1.addVoz(v4);
            p1.setAndamento(andamento / 100);
            p1.setGanho(0.5f);
            return p1;
    }
    public Polifonia getToneContinuo(float andamento) {
                prepara_Instrumentos();
                LinkedList<Melodia> c1,c2,c3,c4;
                c1 = new LinkedList<Melodia>();
                c2 = new LinkedList<Melodia>();
                c3 = new LinkedList<Melodia>();
                c4 = new LinkedList<Melodia>();
                for(int i=0;i<12;i++)
                {
                	c1.add(new Melodia());
                	c2.add(new Melodia());
                	c3.add(new Melodia());
                	c4.add(new Melodia());
                }
                float base = 10f;
                float mult = base / frequencias1.size();
                c1.get(0).addNota(new Nota(1f, frequencias1.get(0), base - (0 * mult) / 2)); // 100% ~ 50%
                c2.get(0).addNota(new Nota(1f, frequencias2.get(0), base / 2 + ((0 * mult) / 2))); // 50% ~ 100%
                c3.get(0).addNota(new Nota(1f, frequencias3.get(0), base / 2 - ((0 * mult) / 2))); // 50% ~ 0%
                c4.get(0).addNota(new Nota(1f, frequencias4.get(0),0 + (0 * mult) / 2)); // 0% ~ 50%
                //for (int k = 0; k < 2; k++) {
                        for (int i = 1; i < frequencias1.size(); i++) {
                        		c1.get(i).addNota(new Nota(i));
                                c1.get(i).addNota(new Nota(1f, frequencias1.get(i), base - (i * mult) / 2)); // 100% ~ 50%
                                c2.get(i).addNota(new Nota(i));
                                c2.get(i).addNota(new Nota(1f, frequencias2.get(i), base / 2 + ((i * mult) / 2))); // 50% ~ 100%
                                c3.get(i).addNota(new Nota(i));
                                c3.get(i).addNota(new Nota(1f, frequencias3.get(i), base / 2 - ((i * mult) / 2))); // 50% ~ 0%
                                c4.get(i).addNota(new Nota(i));
                                c4.get(i).addNota(new Nota(1f, frequencias4.get(i),0 + (i * mult) / 2)); // 0% ~ 50%
                        }
                //}
                LinkedList<Voz> v1,v2,v3,v4;
                v1 = new LinkedList<Voz>();
                v2 = new LinkedList<Voz>();
                v3 = new LinkedList<Voz>();
                v4 = new LinkedList<Voz>();
                for(int i=0;i<12;i++)
                {
                	v1.add(new Voz(Ins1));
                	v2.add(new Voz(Ins1));
                	v3.add(new Voz(Ins1));
                	v4.add(new Voz(Ins1));
                }
                for(int i=0;i<12;i++)
                {
                	v1.get(i).addMelodia(c1.get(i));
                	v2.get(i).addMelodia(c2.get(i));
                	v3.get(i).addMelodia(c3.get(i));
                	v4.get(i).addMelodia(c4.get(i));
                }
                Polifonia p1 = new Polifonia();
                for(int i=0;i<12;i++)
                {
                	p1.addVoz(v1.get(i));
                }
                for(int i=0;i<12;i++)
                {
                	p1.addVoz(v2.get(i));
                }
                for(int i=0;i<12;i++)
                {
                	p1.addVoz(v3.get(i));
                }
                for(int i=0;i<12;i++)
                {
                	p1.addVoz(v4.get(i));
                }
                p1.setAndamento(andamento / 100);
                p1.setGanho(0.5f);
                return p1;
        }

        public static Double getFreq(int i) {
                return (440 * Math.pow(2, i / 12f));
        }
        
        public static LinkedList<Double> frequencias1 = new LinkedList<Double>();
        public static LinkedList<Double> frequencias2 = new LinkedList<Double>();
        public static LinkedList<Double> frequencias3 = new LinkedList<Double>();
        public static LinkedList<Double> frequencias4 = new LinkedList<Double>();

        static {
        		for(int i=-21;i<-9;i++)
        		{
        			frequencias1.add(new Double(getFreq(i)));
        		}
        		//
        		for(int i=-33;i<-21;i++)
        		{
        			frequencias2.add(new Double(getFreq(i)));
        		}
        		//
        		for(int i=-9;i< 3;i++)
        		{
        			frequencias3.add(new Double(getFreq(i)));
        		}
        		//
        		for(int i=-45;i<-33;i++)
        		{
        			frequencias4.add(new Double(getFreq(i)));
        		}
        		//
        }

        /**
         * Create the frame.
         */
        public Interface() {
                setTitle("Efeito Shepard v1.0");
                // inicia_lista();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setBounds(100, 100, 450, 285);
                contentPane = new JPanel();
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                setContentPane(contentPane);
                contentPane.setLayout(null);
                JButton btnVisualizar = new JButton("Visualizar");
                btnVisualizar.setBounds(335, 167, 81, 69);
                contentPane.add(btnVisualizar);

                JButton btnTocar = new JButton("Tocar");
                btnTocar.setBounds(244, 167, 81, 69);
                contentPane.add(btnTocar);

                JPanel panel = new JPanel();
                panel.setBounds(10, 11, 224, 125);
                contentPane.add(panel);
                final JSlider sliderAndamento = new JSlider();
                sliderAndamento.setFont(new Font("Arial", Font.PLAIN, 10));
                sliderAndamento.setMaximum(200);
                sliderAndamento.setToolTipText("Escolha o valor da % de andamento");
                sliderAndamento.setMinimum(1);
                sliderAndamento.setBounds(335, 118, 81, 23);
                sliderAndamento.setValue(100);
                contentPane.add(sliderAndamento);

                textFAndamento = new JTextField();
                textFAndamento.setBounds(244, 116, 86, 20);
                contentPane.add(textFAndamento);
                textFAndamento.setColumns(10);
                textFAndamento.setText("Andamento : " + andamento_atual + "%");
                sliderAndamento.addChangeListener(new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                                JSlider source = (JSlider) e.getSource();
                                if (!source.getValueIsAdjusting()) {
                                        int valor = (source.getValue());
                                        if (valor != andamento_atual) {
                                                andamento_atual = valor;
                                                sliderAndamento.setValue(valor);
                                                textFAndamento.setText("Andamento : " + valor + "%");
                                        }
                                }
                        }
                });
                btnTocar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	Som som = getToneContinuo(andamento_atual).getSom();
                    	som.salvawave("teste_continuo.wav");
                        som.visualiza();
                    }
            });
                btnVisualizar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	Som som = getTone(andamento_atual).getSom();
                        	som.salvawave("teste.wav");
                            som.visualiza();
                        }
                });
        }
}