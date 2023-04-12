//coming up with file names is hard, okay??



const Discord = require('discord.js');
const client = new Discord.Client();

// SELF IMPORT YOUR OWN DEEP LEARNING 
const model = require('./RANDOMMODEL.js');

client.on('ready', () => {
    console.log(`Logged in as ${client.user.tag}!`);
});

client.on('message', async message => {
    if (message.content.startsWith('!botName')) {
        const request = message.content.slice(8);
        
        // Generate a response using your SELF IMPORTED DEEP LEARNING MODEL
        const response = model.predict(request);

        message.channel.send(response);
    }
});

client.login('DISCORD_BOT_TOKEN');
