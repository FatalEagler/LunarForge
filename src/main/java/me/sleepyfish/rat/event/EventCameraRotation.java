package me.sleepyfish.rat.event;

import me.sleepyfish.rat.event.function.Event;

public class EventCameraRotation extends Event {

	private float yaw;
	private float pitch;
	private float roll;

	public EventCameraRotation(float yaw, float pitch, float roll) {
		this.yaw = yaw;
		this.pitch = pitch;
		this.roll = roll;
	}

	public float getYaw() {
		return yaw;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public float getRoll() {
		return roll;
	}

}