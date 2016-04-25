package br.com.toyoda.direction;

import br.com.toyoda.orientation.EastMoviment;
import br.com.toyoda.orientation.NorthMoviment;
import br.com.toyoda.orientation.OrientationMoviment;
import br.com.toyoda.orientation.SouthMoviment;
import br.com.toyoda.orientation.WestMoviment;

public enum Direction {

	N {
		@Override
		public OrientationMoviment getOrientation() {
			return new NorthMoviment();
		}
	},
	S {
		@Override
		public OrientationMoviment getOrientation() {
			return new SouthMoviment();
		}
	},
	W {
		@Override
		public OrientationMoviment getOrientation() {
			return new WestMoviment();
		}
	},
	E {
		@Override
		public OrientationMoviment getOrientation() {
			return new EastMoviment();
		}
	};

	public abstract OrientationMoviment getOrientation();
}