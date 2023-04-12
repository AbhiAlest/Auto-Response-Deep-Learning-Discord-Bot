import discord
import random

from tensorflow.keras.models import load_model
model = load_model('deepLearningModel.h5')     #IMPORTANT: CHOOSE YOUR OWN DEEP LEARNING MODEL. 'deepLearningModel.h5' is obvioously a placeholder value. 

client = discord.Client()

@client.event
async def on_ready():
    print('Logged in through {0.user}'.format(client))

@client.event
async def on_message(message):
    if message.content.startswith('!botName'):
        request = message.content[8:]
        
        # Deep learning model's response
        response = model.predict(request) #obviously a placeholder 
         
        await message.channel.send(response)

client.run('DISCORD_BOT_TOKEN')
