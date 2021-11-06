package me.thecuddlybear.ultimation.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.StoneButtonBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class CustomWeatheringButtonBlock extends StoneButtonBlock implements WeatheringCopper {
    private final WeatheringCopper.WeatherState weatherState;

    public CustomWeatheringButtonBlock(WeatheringCopper.WeatherState weatherState, BlockBehaviour.Properties properties){
        super(properties);
        this.weatherState = weatherState;
    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
        this.onRandomTick(pState, pLevel, pPos, pRandom);
    }

    public boolean isRandomlyTicking(BlockState pState) {
        return WeatheringCopper.getNext(pState.getBlock()).isPresent();
    }

    public WeatheringCopper.WeatherState getAge() {
        return this.weatherState;
    }

}
