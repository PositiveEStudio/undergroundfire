package dev.positivee.undergroundfire.common;

import dev.positivee.undergroundfire.block.BlockGasCoal;

public class Constants
{
	public static final int CONC_MAX = BlockGasCoal.CONCENTRATION.getPossibleValues().stream().max(Integer::compareTo).get();
	public static final int CONC_MIN = BlockGasCoal.CONCENTRATION.getPossibleValues().stream().min(Integer::compareTo).get();
}
