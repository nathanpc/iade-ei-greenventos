from flask import Flask

app = Flask(__name__)

@app.route("/")
def hello_world():
    return "<p>Hello, World!</p>"

@app.route('/events')
def list_events():

    return {
        'events': [
            {
                'id': 123,
                'title': 'Tech Club',
                'date': '234567890',
                'room': 'Tech Lab (IoT)',
                'durationMinutes': 60 * 5,
                'rsvp': 8,
                'description': 'The best event in IADE.'
            },
            {
                'id': 234,
                'title': 'Aula de Mobile',
                'date': '234567890',
                'room': 'Sala 122',
                'durationMinutes': 60 * 3,
                'rsvp': 30,
                'description': 'Class with L-EI A2 D02'
            }
        ],
        'test': 'whatever'
    }
