package jp.techacademy.daiju.kusumi.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

/**
 * Created by USER on 2017/09/28.
 */

public class Enemy extends GameObject {
    // 横幅、高さ
    public static final float ENEMY_WIDTH = 0.8f;
    public static final float ENEMY_HEIGHT = 0.8f;

    // 状態
    public static final int ENEMY_EXIST = 0;
    public static final int ENEMY_VANISH = 1;

    // 常に動くため、動きのステータスは設定しない

    // 動きの速度
    public static final float ENEMY_VELOCITY_HORIZONTAL = 2.0f;
    public static final float ENEMY_VELOCITY_VERTICAL = 1.0f;

    int mState;
    Random mRandom = new Random();

    public Enemy(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
        mState = ENEMY_EXIST;

        if (mRandom.nextFloat() > 0.5f) {
            velocity.x = ENEMY_VELOCITY_HORIZONTAL;
            velocity.y = ENEMY_VELOCITY_VERTICAL;
        } else {
            velocity.x = - ENEMY_VELOCITY_HORIZONTAL;
            velocity.y = ENEMY_VELOCITY_VERTICAL;
        }

    }

    public void update(float deltaTime) {
        //Enemyの動きを定義する

            setX(getX() + velocity.x * deltaTime);
            setY(getY() - velocity.y * deltaTime);


        if (getX() < ENEMY_WIDTH / 2) {
//            velocity.x = -velocity.x;
            setX(GameScreen.WORLD_WIDTH - ENEMY_WIDTH / 2);
        }
        if (getX() > GameScreen.WORLD_WIDTH - ENEMY_WIDTH / 2) {
//            velocity.x = -velocity.x;
            setX(ENEMY_WIDTH / 2);
        }

    }
}
