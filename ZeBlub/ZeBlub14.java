import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ZeBlub14 {
	
	enum ViechZustand { LINKS1, LINKS2, RECHTS1, RECHTS2, FRESS1, FRESS2, WART1, WART2, FALL };
	enum AufzugZustand { STEHT_OBEN, STEHT_UNTEN, FAEHRT_RUNTER, FAEHRT_HOCH };
	
	class SpielFenster extends Frame {
		
		MediaTracker mediaTracker = new MediaTracker(this);
		Image palmwedel;
		ArrayList<Spielobjekt> objekte = new ArrayList<Spielobjekt>(); 
		Spiellogik logik;
		static final int BODEN_Y = 360; 
		static final int VIECH_HOEHE = 56;
		static final int POOL_BREITE = 300;
		static final int SCHRITT_DELTAX = 20;

		public SpielFenster(String titel) {
			this.setTitle(titel);
			this.setSize(750, 400);
			this.setBackground(Color.WHITE);
			// zentriere das Fenster
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
			
			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					logik.geklickt(e.getX(), e.getY());
				}
			});
			
			palmwedel = ladeBild("palmwedel");
		}
		
		Image ladeBild(String bildname) {
			Image ergebnis = getToolkit().getImage("images/" + bildname + ".png");
			mediaTracker.addImage(ergebnis, 0);
			try {
				mediaTracker.waitForAll();
			} catch (InterruptedException e) { }
			
			return ergebnis;
		}
		
		public void zeichne(Graphics g) {
			// Boden
			g.setColor(new Color(179, 100, 29));
			g.fillRect(POOL_BREITE, BODEN_Y, getWidth() - POOL_BREITE, 20);
			
			// Palmenstiel
			g.setColor(new Color(179, 100, 29));
			g.fillRect(390, 90, 15, 290);
			g.setColor(Color.MAGENTA);
			g.fillRect(250, 150, 500, 10);

			// Palmwedel
			g.drawImage(palmwedel, 250, 30, this);
			
			// zeichne Spielobjekte
			for (Spielobjekt o: objekte) {
				o.zeichne(g);
			}

			// Wasser
			g.setColor(Color.BLUE);
			g.fillRect(0, 330, POOL_BREITE, 50);
		}
		
		@Override
		public void paint(Graphics g) {
			
			Graphics offgc;
		    // create the offscreen buffer and associated Graphics
		    Image offscreen = createImage(this.getWidth(), this.getHeight());
		    offgc = offscreen.getGraphics();
		    // clear the exposed area
		    offgc.setColor(getBackground());
		    offgc.fillRect(0, 0, this.getWidth(), this.getHeight());
		    offgc.setColor(getForeground());
		    // do normal redraw
		    zeichne(offgc);
		    // transfer offscreen to window
		    g.drawImage(offscreen, 0, 0, this);			
		}

		public void dazu(Spielobjekt objekt) {
			objekte.add(objekt);
		}
	}
	
	abstract class Spielobjekt {
		SpielFenster spielfenster;
		int x, y;
		
		public Spielobjekt(SpielFenster spielfenster, int x, int y) {
			this.spielfenster = spielfenster;
			this.x = x;
			this.y = y;
		}
		
		public abstract void zeichne(Graphics g);
		
		public abstract int getHoehe();
		
		public abstract int getBreite();
	}
	
	class Apfel extends Spielobjekt {
		Image apfelGanz;
		Image apfelButz;
		boolean gegessen;
		boolean imAufzug;

		public Apfel(SpielFenster spielfenster, int x, int y) {
			super(spielfenster, x, y);
			
			apfelGanz = spielfenster.ladeBild("apfelGanz");
			apfelButz = spielfenster.ladeBild("apfelButz");
		}

		@Override
		public void zeichne(Graphics g) {
			if (gegessen)
				g.drawImage(apfelButz, x, y, spielfenster);
			else
				g.drawImage(apfelGanz, x, y, spielfenster);
		}

		@Override
		public int getHoehe() {
			return apfelGanz.getHeight(spielfenster);
		}

		@Override
		public int getBreite() {
			return apfelGanz.getWidth(spielfenster);
		}
	}
	
	class Viech extends Spielobjekt {
		ViechZustand zustand;
		Image viech_links1;
		Image viech_links2;
		Image viech_rechts1;
		Image viech_rechts2;
		Image viech_fress1;
		Image viech_fress2;
		Image viech_wart1;
		Image viech_wart2;
		boolean imAufzug;
		
		public Viech(SpielFenster spielfenster, int x, int y) {
			super(spielfenster, x, y);
			
			viech_links1   = spielfenster.ladeBild("viech_links1");
			viech_links2   = spielfenster.ladeBild("viech_links2");
			viech_rechts1  = spielfenster.ladeBild("viech_rechts1");
			viech_rechts2  = spielfenster.ladeBild("viech_rechts2");
			viech_fress1   = spielfenster.ladeBild("viech_fress1");
			viech_fress2   = spielfenster.ladeBild("viech_fress2");
			viech_wart1    = spielfenster.ladeBild("viech_wart1");
			viech_wart2    = spielfenster.ladeBild("viech_wart2");
			
			zustand = ViechZustand.WART1;
		}

		@Override
		public void zeichne(Graphics g) {
			Image bild = null;
			switch (zustand) {
			case LINKS1: bild = viech_links1; break;
			case LINKS2: bild = viech_links2; break;
			case RECHTS1: bild = viech_rechts1; break;
			case RECHTS2: bild = viech_rechts2; break;
			case FRESS1: bild = viech_fress1; break;
			case FRESS2: bild = viech_fress2; break;
			case WART1: bild = viech_wart1; break;
			case WART2: bild = viech_wart2; break;
			case FALL: bild = viech_links1; break;
			}
			if (bild != null)
				g.drawImage(bild, x, y, spielfenster);
		}

		public int getBreite() {
			switch (zustand) {
			case LINKS1: return 70;
			case LINKS2: return 70;
			case RECHTS1: return 70;
			case RECHTS2: return 70;
			case FRESS1: return 60;
			case FRESS2: return 60;
			case WART1: return 60;
			case WART2: return 60;
			case FALL: return 70;
			}
			return 60;
		}

		@Override
		public int getHoehe() {
			return 60;
		}		
	}
	
	class Aufzug extends Spielobjekt {
		AufzugZustand zustand;

		public Aufzug(SpielFenster spielfenster, int x, int y) {
			super(spielfenster, x, y);
			zustand = AufzugZustand.STEHT_OBEN;
		}

		@Override
		public void zeichne(Graphics g) {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, 150, 10);
			g.drawRect(x, y - 80, 150, 80);			
		}

		@Override
		public int getHoehe() {
			return 80;
		}

		@Override
		public int getBreite() {
			return 150;
		}
	}
	
	class Blubb extends Spielobjekt {
		int anzeigedauer;

		public Blubb(SpielFenster spielfenster, int x, int y) {
			super(spielfenster, x, y);
		}

		@Override
		public void zeichne(Graphics g) {
			if (anzeigedauer > 0) {
				g.setColor(Color.BLUE);
				g.setFont(new Font(null,Font.BOLD,30));
				g.drawString("BLUBB", x, y);
			}
		}

		@Override
		public int getHoehe() {
			return 0;
		}

		@Override
		public int getBreite() {
			return 0;
		}
	}
	
	class Spiellogik {
		SpielFenster spielfenster;
		Apfel apfel;
		Viech viech;
		Aufzug aufzug;
		Blubb blubb;
		
		Spiellogik(SpielFenster spielfenster) {
			this.spielfenster = spielfenster;
			this.spielfenster.logik = this;
			
			apfel = new Apfel(spielfenster, 300, 55);
			spielfenster.dazu(apfel);
			
			viech = new Viech(spielfenster, 360, SpielFenster.BODEN_Y - SpielFenster.VIECH_HOEHE);
			spielfenster.dazu(viech);
			
			aufzug = new Aufzug(spielfenster, 550, 150);
			spielfenster.dazu(aufzug);
			
			blubb = new Blubb(spielfenster, 100, 330);
			spielfenster.dazu(blubb);
		}

		public void geklickt(int x, int y) {
			if (aufzug.zustand == AufzugZustand.STEHT_OBEN || aufzug.zustand == AufzugZustand.STEHT_UNTEN) {
				versetzeApfel(x - 15, y - 15);
			}
		}
		
		boolean viechImAufzug() {
			return (Math.abs(viech.y + viech.getHoehe() - aufzug.y) < 10
					&& viech.x >= aufzug.x && viech.x + viech.getBreite() < aufzug.x + aufzug.getBreite());
		}

		private void versetzeApfel(int x, int y) {
			apfel.x = x;
			apfel.y = y;
			apfel.gegessen = false;
			
			boolean bewegeViech = true;
			apfel.imAufzug = false;
			
			// X auf Hoehe Aufzug?
			if (apfel.x >= aufzug.x && apfel.x <= aufzug.x + aufzug.getBreite()) {
				// Y im Aufzug?
				if (apfel.y >= aufzug.y - aufzug.getHoehe() && apfel.y <= aufzug.y) {
					if (aufzug.zustand != AufzugZustand.STEHT_UNTEN) {
						aufzug.zustand = AufzugZustand.FAEHRT_RUNTER;
						apfel.imAufzug = true;
						bewegeViech = false;
						if (viechImAufzug()) {
							viech.imAufzug = true;
							viech.zustand = ViechZustand.WART1;
						}
					}
				} else
				// Y ueber Aufzug?
				if (apfel.y < aufzug.y - aufzug.getHoehe()) {
					if (aufzug.zustand != AufzugZustand.STEHT_OBEN) {
						aufzug.zustand = AufzugZustand.FAEHRT_HOCH;
						apfel.imAufzug = true;
						bewegeViech = false;
						if (viechImAufzug()) {
							viech.imAufzug = true;
							viech.zustand = ViechZustand.WART1;
						}
					}
				}
			}

			if (bewegeViech) {
				if (apfel.x > viech.x) {
					viech.zustand = ViechZustand.RECHTS1;
				}
				else
				if (apfel.x < viech.x) {
					viech.zustand = ViechZustand.LINKS1;
				}
			} else
				viech.zustand = ViechZustand.WART1;
		}

		public void schritt() {
			// Bildfolge
			switch (viech.zustand) {
			case RECHTS1: {
				viech.zustand = ViechZustand.RECHTS2;
				break;
			}
			case RECHTS2: {
				viech.zustand = ViechZustand.RECHTS1;
				break;
			}
			case LINKS1: {
				viech.zustand = ViechZustand.LINKS2;
				break;
			}
			case LINKS2: {
				viech.zustand = ViechZustand.LINKS1;
				break;
			}			
			case FRESS1: {
				viech.zustand = ViechZustand.FRESS2;
				break;
			}
			case FRESS2: {
				viech.zustand = ViechZustand.FRESS1;
				break;
			}
			case WART1: {
				viech.zustand = ViechZustand.WART2;
				break;
			}
			case WART2: {
				viech.zustand = ViechZustand.WART1;
				break;
			}						
			case FALL: {
				// TODO
				break;
			}						
			}
			
			// Bewegung Viech
			switch (viech.zustand) {
			case RECHTS1: 
			case RECHTS2: {
				viech.x += SpielFenster.SCHRITT_DELTAX;
				// Apfel erreicht?
				if (apfel.x + apfel.getBreite() / 2 <= viech.x + viech.getBreite()) {
					if (Math.abs((apfel.y + apfel.getHoehe() / 2) // Apfelmitte
						- (viech.y + viech.getHoehe() / 2) // Viechmitte
						) <= apfel.getHoehe()) {
						viech.zustand = ViechZustand.FRESS1;
						apfel.gegessen = true;
					} else {
						viech.zustand = ViechZustand.WART1;
					}
				}
				break;
			}
			case LINKS1:
			case LINKS2: {
				viech.x -= SpielFenster.SCHRITT_DELTAX;
				// Fall?
				if (viech.x < 250 - viech.getBreite() && viech.y - viech.getHoehe() < SpielFenster.BODEN_Y) {
					viech.zustand = ViechZustand.FALL;
				}
				else
				// Apfel erreicht?
				if (apfel.x + apfel.getBreite() >= viech.x) {
					if (Math.abs((apfel.y + apfel.getHoehe() / 2) // Apfelmitte
						- (viech.y + viech.getHoehe() / 2) // Viechmitte
						) <= apfel.getHoehe()) {
						viech.zustand = ViechZustand.FRESS1;
						apfel.gegessen = true;
					} else {
						viech.zustand = ViechZustand.WART1;
					}
				}
				break;
			}
			case FALL: {
				viech.y += 25;
				viech.x -= 5;
				if (viech.y + viech.getHoehe() >= SpielFenster.BODEN_Y) {
					viech.y = SpielFenster.BODEN_Y - viech.getHoehe();
					viech.zustand = ViechZustand.WART1;
					blubb.x = viech.x;
					// blubb.y = viech.y - 25;
					blubb.anzeigedauer = 10;
				}
			}
			}
			
			// Pruefung auf Bildgrenze
			if (viech.x < 0) {
				viech.x = 0;
				viech.zustand = ViechZustand.WART1;
			}
			if (viech.x > spielfenster.getWidth() - viech.getBreite()) {
				viech.x = spielfenster.getWidth() - viech.getBreite();
				viech.zustand = ViechZustand.WART1;
			}
			
			// Bewegung Aufzug
			switch (aufzug.zustand) {
			case FAEHRT_HOCH: {
				aufzug.y -= 10;
				if (apfel.imAufzug) {
					// Apfel mitnehmen?
					if (apfel.y + apfel.getHoehe() > aufzug.y - aufzug.getHoehe())
						apfel.y = aufzug.y - aufzug.getHoehe() - apfel.getHoehe();
				}
				if (viech.imAufzug)
					viech.y -= 10;
				if (aufzug.y <= 150) {
					aufzug.zustand = AufzugZustand.STEHT_OBEN;
					viech.imAufzug = false;
				}
				break;
			}
			case FAEHRT_RUNTER: {
				aufzug.y += 10;
				if (apfel.imAufzug)
					apfel.y += 10;
				if (viech.imAufzug)
					viech.y += 10;
				if (aufzug.y >= SpielFenster.BODEN_Y) {
					aufzug.zustand = AufzugZustand.STEHT_UNTEN;
					viech.imAufzug = false;
					if (apfel.x > viech.x) {
						viech.zustand = ViechZustand.RECHTS1;
					}
					else
					if (apfel.x < viech.x) {
						viech.zustand = ViechZustand.LINKS1;
					}
				}
				break;
			}
			}
			
			if (blubb.anzeigedauer > 0)
				blubb.anzeigedauer--;
			
			spielfenster.repaint();
		}
	}
	
	void run() {
		SpielFenster fenster = new SpielFenster("Platsch!");
		Spiellogik logik = new Spiellogik(fenster);

		fenster.setVisible(true);
		
		// Spielschleife
		while (true) {
			
			logik.schritt();
			
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ZeBlub14().run();
	}

}
